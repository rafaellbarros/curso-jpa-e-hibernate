package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="apolice_seguro")
@EqualsAndHashCode(of = {"codigo"})
public class ApoliceSeguro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "valor_franquia")
	private BigDecimal valorFranquia;

	@Column(name = "protecao_terceiro")
	private Boolean protecaoTerceiro;

	@Column(name = "protecao_causa_naturais")
	private Boolean protecaoCausasNaturais;

	@Column(name = "protecao_roubo")
	private Boolean protecaoRoubo;

}
