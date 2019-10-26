package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of = {"codigo"})
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "codigo_carro")
	private Carro carro;

	@OneToOne
	@JoinColumn(name = "codigo_apolice_seguro")
	private ApoliceSeguro apoliceSeguro;

}
