package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.algaworks.curso.jpa2.modelo.enums.Categoria;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of = {"codigo"})
public class ModeloCarro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="codigo_fabricante")
	private Fabricante fabricante;
	
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
}
