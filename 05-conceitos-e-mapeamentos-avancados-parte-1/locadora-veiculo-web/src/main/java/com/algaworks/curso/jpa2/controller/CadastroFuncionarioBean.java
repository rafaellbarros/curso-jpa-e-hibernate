package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.modelo.enums.Sexo;
import com.algaworks.curso.jpa2.service.CadastroFuncionarioService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Funcionario funcionario;

    @Inject
    private CadastroFuncionarioService cadastroFuncionarioService;

    @Getter
    private List<Sexo> sexos;

    @PostConstruct
    public void inicializar() {
        this.limpar();
        this.sexos = Arrays.asList(Sexo.values());
    }

    public void salvar() {
        try {
            this.cadastroFuncionarioService.salvar(funcionario);
            FacesUtil.addSuccessMessage("Funcionário salvo com sucesso!");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }

        this.limpar();
    }

    public void limpar() {
        this.funcionario = new Funcionario();
    }
}