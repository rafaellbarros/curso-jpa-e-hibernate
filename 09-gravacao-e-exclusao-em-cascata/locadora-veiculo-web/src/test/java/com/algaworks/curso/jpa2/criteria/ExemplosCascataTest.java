package com.algaworks.curso.jpa2.criteria;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelo.enums.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ExemplosCascataTest {

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
    public void exemploEntidadeTransiente() {
        Carro carro = new Carro();
        carro.setCor("Preto");
        carro.setPlaca("AAA-1111");

        ModeloCarro modelo = new ModeloCarro();
        modelo.setCategoria(Categoria.ESPORTIVO);
        modelo.setDescricao("Ferrari");
        carro.setModelo(modelo);
/*
        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
*/
    }

    @Test
    public void gravacaoEmCascataCarroEAcessorio() {
        Carro carro = new Carro();
        carro.setCor("Preto");
        carro.setPlaca("AAA-1111");

        List<Acessorio> acessorios = Arrays.asList(new Acessorio("Air Bag"), new Acessorio("Trava Elétrica"));
        carro.setAcessorios(acessorios);
    /*
        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();

     */

    }

    @Test
    public void exclusaoEmCascata() {
        Carro carro = em.find(Carro.class, 1L);

        /*
        em.getTransaction().begin();
        em.remove(carro);
        em.getTransaction().commit();
         */
    }
    
    @Test
    public void exclusaoDeObjetosOrfaos() {
        Carro carro = em.find(Carro.class, 4L);
        /*
        em.getTransaction().begin();
        carro.getAlugueis().remove(0);
        em.getTransaction().commit();
         */
    }
}
