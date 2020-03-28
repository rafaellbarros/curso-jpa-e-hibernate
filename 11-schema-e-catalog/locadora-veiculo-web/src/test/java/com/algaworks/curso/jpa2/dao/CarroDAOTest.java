package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

public class CarroDAOTest {

    private JIntegrity helper = new JIntegrity();

    private CarroDAO dao;

    private EntityManager em;

    @Before
    public void init() {
        helper.cleanAndInsert();

        dao = new CarroDAO();
        em = JPAHelper.currentEntityManager();
        dao.setEntityManger(em);
    }

    @Test
    public void deveBuscarCarroPeloCodigo() {
        final Carro carro = dao.buscarPeloCodigo(99L);
        assertEquals(99L, carro.getCodigo().longValue());
        assertEquals("ZPT-2211", carro.getPlaca());
    }

    @After
    public void tearDown() {
        dao = null;
        helper.clean();
        em.close();
    }
}
