package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("MOTORISTA")
public class Motorista extends Pessoa {

	@Column(name = "numero_cnh")
	private String numeroCNH;
	
}