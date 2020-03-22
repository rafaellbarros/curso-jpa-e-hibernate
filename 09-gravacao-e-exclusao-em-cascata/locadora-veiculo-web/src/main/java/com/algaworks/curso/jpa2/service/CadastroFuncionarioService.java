package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroFuncionarioService implements Serializable {

    @Inject
    private FuncionarioDAO funcionarioDAO;

    @Transactional
    public void salvar(Funcionario funcionario) throws NegocioException {
        this.funcionarioDAO.salvar(funcionario);
    }
}
