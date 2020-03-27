package com.algaworks.curso.jpa2.criteria;

import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ExemplosAbstractTest {

    private static EntityManagerFactory factory;

    @Getter
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
}
