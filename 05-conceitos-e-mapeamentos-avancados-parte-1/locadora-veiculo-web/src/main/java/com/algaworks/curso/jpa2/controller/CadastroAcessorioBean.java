package com.algaworks.curso.jpa2.controller;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.CadastroAcessorioService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Acessorio acessorio;

	@Inject
	private CadastroAcessorioService cadastroAcessorioService;

	public CadastroAcessorioBean() {
		this.limpar();
	}

	public void salvar() {
		try {
			this.cadastroAcessorioService.salvar(acessorio);
			addSuccessMessage("Acessório salvo com sucesso!");
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}

		this.limpar();
	}

	public void limpar() {
		this.acessorio = new Acessorio();
	}

}
