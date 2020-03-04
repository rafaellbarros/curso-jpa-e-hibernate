package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "aluguel")
@EqualsAndHashCode(of = {"codigo"})
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "codigo_carro")
	private Carro carro;

	@OneToOne
	@JoinColumn(name = "codigo_apolice_seguro")
	private ApoliceSeguro apoliceSeguro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_pedido")
	private Calendar dataPedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_entrega")
	private Date dataEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_evolucao")
	private Date dataDevolucao;

	@ManyToOne
	@JoinColumn(name = "codigo_motorista")
	private Motorista motorista;

}
