package com.algaworks.curso.jpa2.criteria;

import com.algaworks.curso.jpa2.modelo.Carro;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

public class ConsultasNativasTest extends ExemplosAbstractTest {

    @Test
    public void consultaNativa() {
        Query query = getEm().createNativeQuery("select * from carro", Carro.class);
        List<Carro> carros = query.getResultList();

        for (Carro carro : carros) {
            System.out.println(carro.getPlaca());
        }
    }
}
