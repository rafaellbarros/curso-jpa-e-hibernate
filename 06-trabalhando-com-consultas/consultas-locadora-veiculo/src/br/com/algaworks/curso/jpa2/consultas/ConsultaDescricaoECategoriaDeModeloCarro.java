package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConsultaDescricaoECategoriaDeModeloCarro {

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        String jpql = "select mc.descricao, mc.categoria from ModeloCarro mc";
        List<Object[]> resultados = em.createQuery(jpql).getResultList();

        for (Object[] obj: resultados) {
            System.out.println("Descrição: " + obj[0] + ". E categoria: " + obj[1]);
        }

        em.close();


    }
}
