package br.com.algaworks.curso.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "agenda")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	private String telefone;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;
	
	public Agenda(String nome, String telefone) {
		this.nome = nome;
		this.dataRegistro = new Date();
		this.telefone = telefone;
	}

}
