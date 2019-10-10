package br.com.algaworks.curso.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algaworks.curso.modelo.Agenda;

public class UpdateAgenda {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = em.find(Agenda.class, 1L);
		
		em.getTransaction().begin();
		
		agenda.setNome("agenda 1 update");
		agenda.setDataRegistro(new Date());
		
		em.getTransaction().commit();
		
		System.out.println("Agenda alterada com sucesso!");
		
	}

}
