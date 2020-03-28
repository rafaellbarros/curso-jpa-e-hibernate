package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

public class FabricanteDAOTest {

    private JIntegrity helper = new JIntegrity();

    private FabricanteDAO dao;

    EntityManager em;

    @Before
    public void init() {
        this.helper.cleanAndInsert();

        this.dao = new FabricanteDAO();

        this.em = JPAHelper.currentEntityManager();

        this.dao.setEntityManger(this.em);


    }

    @Test
    public void deveBuscarFabricantePeloCodigo() {
        final Fabricante fabricante = dao.buscarPeloCodigo(99L);

        assertEquals(99L, fabricante.getCodigo().longValue());
        // assertEquals("Volks", fabricante.getNome());
    }

    @After
    public void tearDown() {
        this.dao = null;
        this.helper.clean();
    }

}
