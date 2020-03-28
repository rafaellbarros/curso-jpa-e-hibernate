package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;

public class FabricanteDAOTest {

    private JIntegrity helper = new JIntegrity();

    private FabricanteDAO dao;

    @Before
    public void init() {
        helper.cleanAndInsert();
        dao = new FabricanteDAO();
        EntityManagerFactory factory = JPAHelper.entityManagerFactory("locadoraVeiculoTestPU");
        dao.setEntityManger(factory.createEntityManager());
    }

    @Test
    public void deveBuscarFabricantePeloCodigo() {
        final Fabricante fabricante = dao.buscarPeloCodigo(1L);

        assertEquals(1L, fabricante.getCodigo().longValue());
        assertEquals("Chevrolet", fabricante.getNome());
    }
}
