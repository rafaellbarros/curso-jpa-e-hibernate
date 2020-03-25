package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelolazy.LazyCarroDataModel;
import com.algaworks.curso.jpa2.service.exception.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CarroDAO carroDAO;
	
	@Getter
	private List<Carro> carros = new ArrayList<>();

	@Getter
	private LazyCarroDataModel lazyCarros;

	@Getter @Setter
	private Carro carroSelecionado;

	@Getter @Setter
	private Carro carroSelecionadoParaExcluir;

	@Getter @Setter
	private Carro carroSelecionadoParaAcessorio;

	public void excluir() {
		try {
			carroDAO.excluir(carroSelecionadoParaExcluir);
			this.carros.remove(carroSelecionadoParaExcluir);
			FacesUtil.addSuccessMessage("Carro placa " + carroSelecionadoParaExcluir.getPlaca() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void inicializar() {
		lazyCarros = new LazyCarroDataModel(carroDAO);
	}

	public void buscarCarroComAcessorios() {
		carroSelecionadoParaAcessorio = carroDAO.buscarCarroComAcessorios(carroSelecionadoParaAcessorio.getCodigo());
	}
	
}
