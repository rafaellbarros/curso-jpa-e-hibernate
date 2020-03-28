package com.algaworks.curso.jpa2.criteria;

import lombok.Getter;
import lombok.Setter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ExemplosAbstractTest {

    @Getter
    private static EntityManagerFactory factory;

    @Getter @Setter
    private EntityManager em;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("locadoraVeiculoTestPU");
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
