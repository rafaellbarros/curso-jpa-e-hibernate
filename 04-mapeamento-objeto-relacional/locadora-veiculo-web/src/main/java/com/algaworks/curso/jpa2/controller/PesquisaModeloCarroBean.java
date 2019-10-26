package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private List<ModeloCarro> modelosCarro;
	
	@Getter @Setter
	private ModeloCarro modeloCarroSelecionado;
	
	@Inject
	ModeloCarroDAO modeloCarroDAO;

	@PostConstruct
	public void inicializar() {
		this.modelosCarro = this.modeloCarroDAO.buscarTodos();
	}
	
	public void excluir() {
		try {
			modeloCarroDAO.excluir(modeloCarroSelecionado);
			this.modelosCarro.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo " + modeloCarroSelecionado.getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
}
