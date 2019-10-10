package br.com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algaworks.curso.modelo.Agenda;


public class CreateAgenda {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		em.persist(new Agenda("agenda 1","3333-0000"));

		em.getTransaction().commit();

		System.out.println("Agenda salva com sucesso!");

	}

}
