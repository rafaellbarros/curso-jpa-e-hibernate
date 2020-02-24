package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.constants.CarroConstants;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 5804238669540543682L;

	@Inject
	private EntityManager em;
	
	public Carro buscarPeloCodigo(Long codigo) {
		return em.find(Carro.class, codigo);
	}
	
	public void salvar(Carro carro) {
		em.merge(carro);
	}

	public List<Carro> buscarTodos() {
		return em.createNamedQuery(CarroConstants.QUERYNAME.BUSCAR_TODOS).getResultList();
	}
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = buscarPeloCodigo(carro.getCodigo());
		try {
			em.remove(carro);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro não pode ser excluído.");
		}
	}


	public Carro buscarCarroComAcessorios(Long codigo) {
		return em.createNamedQuery(CarroConstants.QUERYNAME.BUSCAR_CARRO_COM_ACESSORIOS, Carro.class)
							.setParameter("codigo", codigo)
							.getSingleResult();
	}

}
