package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    FuncionarioDAO funcionarioDAO;

    @Getter
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Getter @Setter
    private Funcionario funcionarioSelecionado;

    public void excluir() {
        try {
            funcionarioDAO.excluir(funcionarioSelecionado);
            this.funcionarios.remove(funcionarioSelecionado);
            FacesUtil.addSuccessMessage("Funcionário " + funcionarioSelecionado.getNome() + " excluído com sucesso.");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
    }

    @PostConstruct
    public void inicializar() {
        funcionarios = funcionarioDAO.buscarTodos();
    }
}