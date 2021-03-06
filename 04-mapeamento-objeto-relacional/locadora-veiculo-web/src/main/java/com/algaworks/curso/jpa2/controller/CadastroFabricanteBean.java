package com.algaworks.curso.jpa2.controller;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFabricanteService cadastroFabricanteService;

	@Getter
	@Setter
	private Fabricante fabricante;

	public void salvar() {
		try {
			this.cadastroFabricanteService.salvar(fabricante);
			addSuccessMessage("Fabricante salvo com sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.fabricante = new Fabricante();
	}

}
