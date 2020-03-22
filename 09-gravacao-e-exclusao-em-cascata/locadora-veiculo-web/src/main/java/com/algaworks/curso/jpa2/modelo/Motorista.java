package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@Entity
@DiscriminatorValue("1")
@Table(name = "motorista")
@EqualsAndHashCode(callSuper=false)
public class Motorista extends Pessoa {

	@Column(name = "numero_cnh")
	private String numeroCNH;
	
}