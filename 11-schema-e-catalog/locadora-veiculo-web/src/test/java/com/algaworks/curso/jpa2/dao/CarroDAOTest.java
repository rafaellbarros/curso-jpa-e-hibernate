package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;

public class CarroDAOTest {

    private JIntegrity helper = new JIntegrity();

    private CarroDAO dao;

    private EntityManager em;

    @Before
    public void init() {
        helper.cleanAndInsert();

        dao = new CarroDAO();
        EntityManagerFactory factory = JPAHelper.entityManagerFactory("locadoraVeiculoTestPU");
        dao.setEntityManger(factory.createEntityManager());
    }

    @Test
    public void deveBuscarCarroPeloCodigo() {
        final Carro carro = dao.buscarPeloCodigo(1L);
        assertEquals(1L, carro.getCodigo().longValue());
        assertEquals("AAA-1111", carro.getPlaca());
    }
}
