package com.algaworks.curso.jpa2.criteria;

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

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();

    }
}
