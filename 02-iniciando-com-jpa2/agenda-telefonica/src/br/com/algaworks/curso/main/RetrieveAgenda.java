package br.com.algaworks.curso.main;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algaworks.curso.modelo.Agenda;

public class RetrieveAgenda {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = em.find(Agenda.class, 1L);
		
		if (Objects.nonNull(agenda)) {
			System.out.println("Nome: " + agenda.getNome());
			System.out.println("Telefone: " + agenda.getTelefone());
			System.out.println("Data Registro: " + agenda.getDataRegistro());
			
		} else {
			System.out.println("Agenda não encontrada.");
		}

	}

}
