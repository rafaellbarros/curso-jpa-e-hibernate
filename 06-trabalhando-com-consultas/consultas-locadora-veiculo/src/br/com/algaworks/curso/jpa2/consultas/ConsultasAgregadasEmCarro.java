package br.com.algaworks.curso.jpa2.consultas;

import br.com.algaworks.curso.jpa2.modelo.Carro;
import br.com.algaworks.curso.jpa2.modelo.info.AluguelCarroInfo;
import br.com.algaworks.curso.jpa2.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConsultasAgregadasEmCarro {

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        String jpql1 = "select c, count(a), max(a.valorTotal), avg(a.valorTotal) "
                + "from Carro c JOIN c.alugueis a "
                + "group by c "
                + "having count(a) > 1";

        String jpql2 = "select new br.com.algaworks.curso.jpa2.modelo.info.AluguelCarroInfo(c, count(a), max(a.valorTotal), avg(a.valorTotal)) "
                + "from Carro c JOIN c.alugueis a "
                + "group by c "
                + "having count(a) > 1";

        List<Object[]> resultados1 = em.createQuery(jpql1).getResultList();
        for (Object[] obj : resultados1) {
            System.out.println("1 Modelo: " + ((Carro) obj[0]).getModelo().getDescricao());
            System.out.println("1 Quantidade de alugueis: " + obj[1]);
            System.out.println("1 Valor máximo: " + obj[2]);
            System.out.println("1 Valor médio: " + obj[3]);
            System.out.println();
        }

        List<AluguelCarroInfo> resultados2 = em.createQuery(jpql2, AluguelCarroInfo.class).getResultList();
        for(AluguelCarroInfo aci : resultados2) {
            System.out.println("2 Modelo: " + aci.getCarro().getModelo().getDescricao());
            System.out.println("2 Quantidade de alugueis: " + aci.getTotalAlugueis());
            System.out.println("2 Valor máximo: " + aci.getValorMaximo());
            System.out.println("2 Valor médio: " + aci.getValorMedio());
            System.out.println();
        }

        em.close();
    }
}
