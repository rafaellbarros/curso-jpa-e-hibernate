package com.algaworks.curso.jpa2.controller;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelo.enums.Categoria;
import com.algaworks.curso.jpa2.service.CadastroModeloCarroService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private ModeloCarro modeloCarro;

	@Getter
	private List<Fabricante> fabricantes;
	
	@Getter
	private List<Categoria> categorias;

	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService;

	@Inject
	private FabricanteDAO fabricanteDAO;

	public void salvar() {
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			addSuccessMessage("Modelo carro salvo com sucesso!");
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}

		this.limpar();
	}

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias = Arrays.asList(Categoria.values());
	}

	public void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

}
