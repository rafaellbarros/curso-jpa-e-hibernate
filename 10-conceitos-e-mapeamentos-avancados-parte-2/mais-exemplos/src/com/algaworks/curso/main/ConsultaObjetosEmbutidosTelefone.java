package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.modelo.ProprietarioEntity;
import com.algaworks.curso.modelo.Telefone;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ConsultaObjetosEmbutidosTelefone {
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		ProprietarioEntity p = em.find(ProprietarioEntity.class, 1L);
		System.out.println("Nome: " + p.getNome());

		// List<String> telefones = p.getTelefones();
		List<Telefone> telefones = p.getTelefones();
		
		for (Telefone telefone : telefones) {
			System.out.println("\n=============================");
			System.out.println("Telefone Prefixo: " + telefone.getPrefixo());
			System.out.println("Telefone Numero: " + telefone.getNumero());
			System.out.println("Telefone Ramal: " + telefone.getRamal());
			System.out.println("=============================\n");
		} 
		
		em.close();
	}

}
