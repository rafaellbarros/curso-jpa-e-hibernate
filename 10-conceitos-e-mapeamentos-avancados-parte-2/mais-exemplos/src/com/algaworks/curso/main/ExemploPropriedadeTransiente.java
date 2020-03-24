package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.modelo.Veiculo;
import com.algaworks.curso.modelo.VeiculoId;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ExemploPropriedadeTransiente {
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = em.find(Veiculo.class, new VeiculoId("AAA-1111", "Rio de Janeiro"));
		
		System.out.println(veiculo.getDescricao());
		
		em.close();
	}

}
