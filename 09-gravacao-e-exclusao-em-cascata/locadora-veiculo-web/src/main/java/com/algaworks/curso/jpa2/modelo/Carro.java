package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.algaworks.curso.jpa2.modelo.constants.CarroConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NamedQueries({
		@NamedQuery(
				name = CarroConstants.QUERYNAME.BUSCAR_TODOS,
				query = CarroConstants.QUERIES.BUSCAR_TODOS),
		@NamedQuery(
				name = CarroConstants.QUERYNAME.BUSCAR_CARRO_COM_ACESSORIOS,
				query = CarroConstants.QUERIES.BUSCAR_CARRO_COM_ACESSORIOS
		)
})
@Table(name="carro")
@EqualsAndHashCode(of = {"codigo"})
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;

	@Column(name = "valor_diaria")
	private BigDecimal valorDiaria;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "codigo_modelo")
	private ModeloCarro modelo;

	@ManyToMany
	@JoinTable(name = "carro_acessorio", joinColumns = @JoinColumn(name = "codigo_carro"), inverseJoinColumns = @JoinColumn(name = "codigo_acessorio"))
	private List<Acessorio> acessorios;
	
	
	@OneToMany(mappedBy="carro")
	private List<Aluguel> alugueis;
	
}
