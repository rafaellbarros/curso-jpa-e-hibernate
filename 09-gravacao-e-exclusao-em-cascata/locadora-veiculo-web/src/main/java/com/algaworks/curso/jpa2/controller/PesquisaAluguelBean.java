package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PesquisaAluguelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private List<ModeloCarro> modelosCarros;

    @Getter
    @Setter
    private Aluguel aluguel;

    @Getter
    @Setter
    private Carro carro;

    @Getter
    private List<Aluguel> alugueis;

    @Inject
    private ModeloCarroDAO modeloCarroDAO;

    @Inject
    private AluguelDAO aluguelDAO;

    @PostConstruct
    public void inicializar() {
        this.aluguel = new Aluguel();
        this.carro = new Carro();
        this.modelosCarros = this.modeloCarroDAO.buscarTodos();

        this.alugueis = new ArrayList<>();
    }

    public void pesquisar() throws Exception {
        this.alugueis = aluguelDAO.buscarPorDataDeEntregaEModeloCarro(this.aluguel.getDataEntrega(), this.carro.getModelo());
    }

}