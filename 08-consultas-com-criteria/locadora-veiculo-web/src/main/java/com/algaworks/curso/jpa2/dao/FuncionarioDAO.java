package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class FuncionarioDAO implements Serializable {

    @Inject
    private EntityManager em;

    public Funcionario buscarPeloCodigo(Long codigo) {
        return em.find(Funcionario.class, codigo);
    }

    public void salvar(Funcionario funcionario) {
        em.merge(funcionario);
    }

    public List<Funcionario> buscarTodos() {
        return em.createQuery("from Funcionario").getResultList();
    }

    @Transactional
    public void excluir(Funcionario funcionario) throws NegocioException {
        funcionario = buscarPeloCodigo(funcionario.getCodigo());
        try {
            em.remove(funcionario);
            em.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Funcionário não pode ser excluído.");
        }
    }

}
