package br.com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;

import com.algaworks.curso.jpa2.modelo.enums.Categoria;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="modelo_carro")
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
