package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name = "acessorio")
@EqualsAndHashCode(of = {"codigo"})
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "A descrição deve ser informada")
	private String descricao;

	public Acessorio() {}

	public Acessorio(String descricao) {
		this.descricao = descricao;
	}
}
