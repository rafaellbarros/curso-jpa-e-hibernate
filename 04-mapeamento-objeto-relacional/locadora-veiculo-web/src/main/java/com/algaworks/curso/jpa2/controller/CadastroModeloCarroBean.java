package com.algaworks.curso.jpa2.controller;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroModeloCarroService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;



@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloCarro modeloCarro;
	
	private List<Fabricante> fabricantes;
	
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
	}
	
	public void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
}
