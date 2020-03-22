package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return em.find(Acessorio.class, codigo);
	}
	
	public void salvar(Acessorio acessorio) {
		em.merge(acessorio);
	}

	public List<Acessorio> buscarTodos() {
		return em.createQuery("from Acessorio").getResultList();
	}
	
	@Transactional
	public void excluir(Acessorio acessorio) throws NegocioException {
		acessorio = buscarPeloCodigo(acessorio.getCodigo());
		try {
			em.remove(acessorio);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Acessorio não pode ser excluído.");
		}
	}
}