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

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.exception.NegocioException;

import lombok.Getter;
import lombok.Setter;


@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FabricanteDAO fabricanteDAO;
	
	@Getter
	private List<Fabricante> fabricantes = new ArrayList<>();
	
	@Getter @Setter
	private Fabricante fabricanteSelecionado;
	

	public void excluir() {
		
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		} 
	}


	
	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteDAO.buscarTodos();
	}
}
