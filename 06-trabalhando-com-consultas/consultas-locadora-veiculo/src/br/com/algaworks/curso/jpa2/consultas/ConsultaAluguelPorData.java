package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConsultaAluguelPorData {

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();


        String jpql = "select count(a) "
                    + "from Aluguel a "
                    + "where a.dataDevolucao BETWEEN :inicio AND :fim";

        Calendar inicioCalendar = Calendar.getInstance();
        inicioCalendar.set(2013, 7,  28, 7, 0);
        Date inicio = inicioCalendar.getTime();

        Calendar fimCalendar = Calendar.getInstance();
        fimCalendar.set(2013, 7, 30, 18, 0);
        Date fim = fimCalendar.getTime();

        Long quantidadeDevolucoes = em.createQuery(jpql, Long.class)
                .setParameter("inicio", inicio, TemporalType.TIMESTAMP)
                .setParameter("fim",  fim, TemporalType.TIMESTAMP)
                .getSingleResult();

        System.out.println("Quantidade de devoluções: " + quantidadeDevolucoes);


        em.close();
    }
}
