package com.algaworks.curso.jpa2.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue("1")
@Table(name = "funcionario")
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa {

    private String matricula;
}
