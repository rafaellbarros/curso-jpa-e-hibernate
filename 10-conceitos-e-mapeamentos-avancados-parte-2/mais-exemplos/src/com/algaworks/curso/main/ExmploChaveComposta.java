package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.modelo.Veiculo;
import com.algaworks.curso.modelo.VeiculoId;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ExmploChaveComposta {
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("ABC-1234", "Rio Claro"));
		veiculo.setFabricante("Chevrolet");
		veiculo.setModelo("Corsa");
		
		/*
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		*/
		VeiculoId codigo = new VeiculoId("ABC-1234", "Rio Claro");
		Veiculo veiculoRetornado = em.find(Veiculo.class, codigo);
		
		System.out.println("Veiculo placa: " + veiculoRetornado.getCodigo().getPlaca());
		System.out.println("Veiculo cidade: " + veiculoRetornado.getCodigo().getCidade());
		System.out.println("Veiculo fabricante: " + veiculoRetornado.getFabricante());
		
		em.close();
	}

}
