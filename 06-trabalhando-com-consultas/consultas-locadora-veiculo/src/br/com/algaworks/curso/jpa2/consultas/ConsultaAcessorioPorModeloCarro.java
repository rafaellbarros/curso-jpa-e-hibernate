package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConsultaAcessorioPorModeloCarro {

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        String jpql = "select a.descricao from Carro c join c.acessorios a where c.modelo.descricao = 'Civic'";

        List<String> acessorios = em.createQuery(jpql, String.class).getResultList();

        for (String acessorio : acessorios) {
            System.out.println("Acessório: " + acessorio);
        }

        em.close();
    }
}
