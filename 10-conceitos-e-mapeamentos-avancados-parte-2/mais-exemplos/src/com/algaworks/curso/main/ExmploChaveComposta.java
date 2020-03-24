package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.util.jpa.JPAUtil;

public class ExmploChaveComposta {
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		
		em.close();
	}

}
