package com.algaworks.curso.jpa2.criteria;

import com.algaworks.curso.jpa2.modelo.Carro;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class CachePrimeiroNivelTest extends ExemplosAbstractTest  {

    @Test
    public void cache() {
        TypedQuery<Carro> query = getEm().createQuery("from Carro c", Carro.class);
        List<Carro> carros = query.getResultList();

        for (Carro carro : carros) {
            System.out.println(carro.getCodigo() + " - " + carro.getPlaca());
        }
        // getEm().close();
        // setEm(getFactory().createEntityManager());
        System.out.println("\n-----------------------------------------------\n");
        Carro carro = getEm().find(Carro.class, 16L);
        System.out.println(carro.getCodigo() + " - " + carro.getPlaca());

    }
}
