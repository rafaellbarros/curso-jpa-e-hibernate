package br.com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algaworks.curso.modelo.Agenda;

public class DeleteAgenda {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = em.find(Agenda.class, 2L);
		
		em.getTransaction().begin();
		em.remove(agenda);
		em.getTransaction().commit();
		
		
		System.out.println("Agenda removida com sucesso!");

	}
}
