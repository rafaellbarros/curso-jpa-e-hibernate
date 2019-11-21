package com.algaworks.curso.jpa2.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "funcionario")
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("1")
public class Funcionario extends Pessoa {

    private String matricula;
}
