package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.CadastroAluguelService;
import com.algaworks.curso.jpa2.service.exception.NegocioException;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Aluguel aluguel;

	@Getter
	private List<Carro> carros;

	@Inject
	private CadastroAluguelService cadastroAluguelService;

	@Inject
	private CarroDAO carroDAO;

	@Inject
	private MotoristaDAO motoristaDAO;

	@Getter
	private List<Motorista> motoristas;

	public void salvar() {
		try {
			this.cadastroAluguelService.salvar(aluguel);
			addSuccessMessage("Aluguel salvo com sucesso!");
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}

		this.limpar();
	}

	@PostConstruct
	public void inicializar() {
		this.limpar();

		this.carros = this.carroDAO.buscarTodos();
		this.motoristas = this.motoristaDAO.buscarTodos();
	}

	public void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

}
