package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConsultaFabricantesPeloModeloCarro {

    public static void main(String[] args) {

        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        List<String> nomeDosFabricantes = em.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class)
                .getResultList();

        for (String nomeFabricante : nomeDosFabricantes) {
            System.out.println("Nome: " + nomeFabricante);
        }
        em.close();
    }
}

