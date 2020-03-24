package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.modelo.ProprietarioEntity;
import com.algaworks.curso.modelo.Telefone;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ExemploObjetosEmbutidosTelefone {
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		ProprietarioEntity p = new ProprietarioEntity();
		p.setNome("Maria");
		p.getTelefones().add(new Telefone("34", "1234-5678", "104"));
		p.getTelefones().add(new Telefone("11", "9876-5432", null));
		
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
	}

}
