package com.algaworks.curso.jpa2.criteria;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import org.junit.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

public class ExemplosCriteriaTest {

    private static EntityManagerFactory factory;

    private EntityManager em;

    String placaExpected;
    BigDecimal valorDiariaExpected;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
    }

    @Before
    public void setUp() {
        em = factory.createEntityManager();
        placaExpected = "AAA-1234";
        valorDiariaExpected = new BigDecimal("200.00");
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void projecoes() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        criteriaQuery.select(carro.<String>get("placa"));

        TypedQuery<String> query = em.createQuery(criteriaQuery);
        List<String> placas = query.getResultList();
        String placaAtual = placas.stream().findFirst().get();

        Assert.assertEquals(placaExpected, placaAtual);
    }

    @Test
    public void funcoesDeAgregacao() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        // builder.max
        // builder.sum
        // builder.min
        CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);
        Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
        criteriaQuery.select(builder.sum(aluguel.<BigDecimal>get("valorTotal")));

        TypedQuery<BigDecimal> query = em.createQuery(criteriaQuery);
        BigDecimal total = query.getSingleResult();
        System.out.println("Soma de todos os alugueis: " + total);
        BigDecimal expected = new BigDecimal("2350.0");
        Assert.assertEquals(expected, total);
    }

    @Test
    public void resultadoComplexo() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        criteriaQuery.multiselect(carro.get("placa"), carro.get("valorDiaria"));
        TypedQuery<Object[]> query = em.createQuery(criteriaQuery);
        List<Object[]> resultado = query.getResultList();

        for (Object[] valores : resultado) {
            System.out.println(valores[0] + " - " + valores[1]);
        }

        String placaExptected = "AAA-1234";
        BigDecimal valorDiariaExpected = new BigDecimal("200.00");

        Object[] objects = resultado.stream().findFirst().get();
        String placaAtual = (String) objects[0];
        BigDecimal valorDiariaAtual = (BigDecimal) objects[1];

        Assert.assertEquals(placaExptected, placaAtual);
        Assert.assertEquals(valorDiariaExpected, valorDiariaAtual);
    }

    @Test
    public void resultadoTupla() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        criteriaQuery.multiselect(carro.get("placa").alias("placaCarro")
                , carro.get("valorDiaria").alias("valorCarro"));

        TypedQuery<Tuple> query = em.createQuery(criteriaQuery);
        List<Tuple> resultado = query.getResultList();

        for (Tuple tuple : resultado) {
            System.out.println(tuple.get("placaCarro") + " - " + tuple.get("valorCarro"));
        }

        Tuple tuple = resultado.stream().findFirst().get();
        String placaCarroAtual = (String) tuple.get("placaCarro");
        BigDecimal valorCarroAtual = (BigDecimal) tuple.get("valorCarro");

        Assert.assertEquals(placaExpected, placaCarroAtual);
        Assert.assertEquals(valorDiariaExpected, valorCarroAtual);
    }

    @Test
    public void resultadoConstrutores() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PrecoCarro> criteriaQuery = builder.createQuery(PrecoCarro.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        criteriaQuery.select(builder.construct(PrecoCarro.class,
                carro.get("placa"), carro.get("valorDiaria")));

        TypedQuery<PrecoCarro> query = em.createQuery(criteriaQuery);
        List<PrecoCarro> resultado = query.getResultList();

        for (PrecoCarro precoCarro : resultado) {
            System.out.println(precoCarro.getPlaca() + " - " + precoCarro.getValor());
        }

        PrecoCarro precoCarro = resultado.stream().findFirst().get();

        Assert.assertEquals(placaExpected, precoCarro.getPlaca());
        Assert.assertEquals(valorDiariaExpected, precoCarro.getValor());
    }
    
    @Test
    public void exemploFuncao() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        Predicate predicate = builder.equal(builder.upper(carro.<String>get("cor")),
                "prata".toUpperCase());

        criteriaQuery.select(carro);
        criteriaQuery.where(predicate);

        TypedQuery<Carro> query = em.createQuery(criteriaQuery);
        List<Carro> carros = query.getResultList();

        for (Carro c : carros) {
            System.out.println(c.getPlaca() + " - " + c.getCor());
        }

        String placa = "BBB-2222";
        String cor = "Prata";

        Carro c = carros.stream().findFirst().get();

        Assert.assertEquals(placa, c.getPlaca());
        Assert.assertEquals(cor, c.getCor());

    }
    
    @Test
    public void exemploOrdenacao() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        Order order = builder.desc(carro.get("valorDiaria"));

        criteriaQuery.select(carro);
        criteriaQuery.orderBy(order);

        TypedQuery<Carro> query = em.createQuery(criteriaQuery);
        List<Carro> carros = query.getResultList();

        for (Carro c : carros) {
            System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
        }

    }

    @Test
    public void exemploJoinEFecth() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        // Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");
        Join<Carro, ModeloCarro> modelo = (Join) carro.join("modelo");

        criteriaQuery.select(carro);
        criteriaQuery.where(builder.equal(modelo.get("descricao") ,"Fit"));

        TypedQuery<Carro> query = em.createQuery(criteriaQuery);
        List<Carro> carros = query.getResultList();

        for (Carro c : carros) {
            // System.out.println(c.getPlaca() + " - " + c.getModelo().getDescricao());
            System.out.println(c.getPlaca());

        }

    }

    @Test
    public void mediaDasDiariasDosCarros() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = builder.createQuery(Double.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        criteriaQuery.select(builder.avg(carro.<Double>get("valorDiaria")));

        TypedQuery<Double> query = em.createQuery(criteriaQuery);
        Double total = query.getSingleResult();

        System.out.println("Média da diária: " + total);
    }

    @Test
    public void carrosComValoresAcimaDaMedia() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
        Subquery<Double> subquery = criteriaQuery.subquery(Double.class);

        Root<Carro> carro = criteriaQuery.from(Carro.class);
        Root<Carro> carroSub = subquery.from(Carro.class);

        subquery.select(builder.avg(carroSub.<Double>get("valorDiaria")));

        criteriaQuery.select(carro);
        criteriaQuery.where(builder.greaterThanOrEqualTo(carro.<Double>get("valorDiaria"), subquery));

        TypedQuery<Carro> query = em.createQuery(criteriaQuery);
        List<Carro> carros = query.getResultList();

        for (Carro c : carros) {
            System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
        }

    }
}
