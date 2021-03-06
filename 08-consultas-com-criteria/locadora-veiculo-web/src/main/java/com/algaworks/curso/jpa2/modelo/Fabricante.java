package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="fabricante")
@EqualsAndHashCode(of = {"codigo"})
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	
}
