package com.algaworks.curso.jpa2.controller;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroCarroService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Carro carro;

	@Getter
	private List<ModeloCarro> modelosCarros;

	@Getter
	private List<Acessorio> acessorios;

	@Inject
	private CadastroCarroService cadastroCarroService;

	@Inject
	private AcessorioDAO acessorioDAO;

	@Inject
	private ModeloCarroDAO modeloCarroDAO;

	@PostConstruct
	public void inicializar() {
		this.limpar();

		this.acessorios = acessorioDAO.buscarTodos();
		this.modelosCarros = this.modeloCarroDAO.buscarTodos();
	}

	public void salvar() {
		try {
			this.cadastroCarroService.salvar(carro);
			addSuccessMessage("Carro salvo com sucesso!");
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			addErrorMessage("Erro desconhecido. Contatar o administrador");
		}

		this.limpar();
	}

	public void limpar() {
		this.carro = new Carro();
		this.carro.setAcessorios(new ArrayList<Acessorio>());
	}
}
