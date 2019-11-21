package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.modelo.enums.Sexo;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 2292827666615468985L;

	@Getter
	@Setter
	private Motorista motorista;

	@Inject
	private CadastroMotoristaService cadastroMotoristaService;

	@Getter
	private List<Sexo> sexos;

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.sexos = Arrays.asList(Sexo.values());
	}

	public void salvar() {
		try {
			this.cadastroMotoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

		this.limpar();
	}

	public void limpar() {
		this.motorista = new Motorista();
	}

}
