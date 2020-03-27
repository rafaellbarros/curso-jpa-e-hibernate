package com.algaworks.curso.jpa2.criteria;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ProblemaNMaisUmTest extends ExemplosAbstractTest {

    @Test
    public void problema() {
        TypedQuery<Carro> query = getEm().createQuery("from Carro c inner join fetch c.modelo", Carro.class);
        List<Carro> carros = query.getResultList();

        for (Carro carro : carros) {
            ModeloCarro modeloCarro = Optional.ofNullable(carro.getModelo()).get();
            System.out.println(carro.getPlaca() + " - " + modeloCarro.getDescricao());
        }
    }
}
