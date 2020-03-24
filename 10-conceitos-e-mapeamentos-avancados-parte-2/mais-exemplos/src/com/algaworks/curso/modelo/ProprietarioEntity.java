package com.algaworks.curso.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class ProprietarioEntity {
	
	private Long codigo;
	private String nome;
	private List<Telefone> telefones = new ArrayList<>();
	
	@Id
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ElementCollection
	@CollectionTable(name = "proprietario_telefones",
			joinColumns=@JoinColumn(name="cod_proprietario"))
	// @Column(name="numero_telefone")
	@AttributeOverrides({@AttributeOverride(name = "numero", column = @Column(name = "num_telefone"))})
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	

}
