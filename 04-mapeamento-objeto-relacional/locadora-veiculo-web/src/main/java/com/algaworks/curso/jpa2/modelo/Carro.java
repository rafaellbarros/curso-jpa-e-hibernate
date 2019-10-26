package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;
	private BigDecimal valorDiaria;
	
	@ManyToOne
	@JoinColumn(name = "codigo_modelo")
	private ModeloCarro modelo;
	
	
	@ManyToMany
	private List<Acessorio> acessorios;
}
