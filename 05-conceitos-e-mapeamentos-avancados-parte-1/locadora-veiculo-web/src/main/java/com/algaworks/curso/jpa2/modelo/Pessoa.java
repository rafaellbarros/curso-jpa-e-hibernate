package com.algaworks.curso.jpa2.modelo;

import java.util.Date;

import javax.persistence.*;

import com.algaworks.curso.jpa2.modelo.enums.Sexo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "pessoa")
@EqualsAndHashCode(of = {"codigo"})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_PESSOA", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	private String cpf;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

}
