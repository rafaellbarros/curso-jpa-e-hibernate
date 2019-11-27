package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConsultaModeloFiltrandoFabricante {

    public static void main(String[] args) {

        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        List<String> modelos = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Chevrolet'", String.class)
                .getResultList();

        for (String modelo : modelos) {
            System.out.println(modelo);
        }
        em.close();
    }
}
