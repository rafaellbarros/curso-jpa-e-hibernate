package br.com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algaworks.curso.modelo.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(new Cliente("Pedro Bial", 40, "M", "Jornalista"));

		em.getTransaction().commit();

		System.out.println("Cliente salvo com sucesso!");

		// em.close();
	}

}
