package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.modelo.ProprietarioEntity;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ConsultaTiposBasicos {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		ProprietarioEntity p = em.find(ProprietarioEntity.class, 1L);
		System.out.println("Nome: " + p.getNome());

		List<String> telefones = p.getTelefones();
		
		for (String telefone : telefones) {
			System.out.println("Telefone: " + telefone);
		} 
		
		em.close();
	}

}
