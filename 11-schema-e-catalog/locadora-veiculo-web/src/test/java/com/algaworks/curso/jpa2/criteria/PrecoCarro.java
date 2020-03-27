package com.algaworks.curso.jpa2.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class PrecoCarro {
    private String placa;
    private BigDecimal valor;
}
