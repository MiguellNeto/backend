package com.miguelneto.backend.entidade;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //classe que representa o banco de dados 
public class Produto {

	
	@Id // Defini o PrimaryKey da Tabela 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PrimaryKey seja gerado automático
	private long id;
	private String nome;
	private BigDecimal valor;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
