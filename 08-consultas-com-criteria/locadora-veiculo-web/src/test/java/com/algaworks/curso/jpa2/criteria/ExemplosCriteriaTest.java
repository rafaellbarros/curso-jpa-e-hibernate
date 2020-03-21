package com.algaworks.curso.jpa2.criteria;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class ExemplosCriteriaTest {

    private static EntityManagerFactory factory;

    private EntityManager em;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
    }

    @Before
    public void setUp() {
        em = factory.createEntityManager();
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
        String placa = placas.stream().findFirst().get();
        String expected = "AAA-1234";
        Assert.assertEquals(expected, placa);
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
    
}
