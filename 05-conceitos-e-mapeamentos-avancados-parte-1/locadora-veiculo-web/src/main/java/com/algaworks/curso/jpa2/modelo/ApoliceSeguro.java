package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="apolice_seguro")
@EqualsAndHashCode(of = {"codigo"})
public class ApoliceSeguro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private BigDecimal valorFranquia;
	private Boolean protecaoTerceiro;
	private Boolean protecaoCausasNaturais;
	private Boolean protecaoRoubo;

}
