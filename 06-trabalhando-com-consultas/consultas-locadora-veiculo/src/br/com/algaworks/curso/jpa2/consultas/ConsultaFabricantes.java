package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.modelo.Fabricante;
import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConsultaFabricantes {

    public static void main(String[] args) {

        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();


        List<Fabricante> fabricantes = em.createQuery("select f from Fabricante f", Fabricante.class)
                .getResultList();

        for (Fabricante f : fabricantes) {
            System.out.println(f);
        }
        em.close();
    }
}
