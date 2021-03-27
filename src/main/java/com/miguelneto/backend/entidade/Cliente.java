package com.miguelneto.backend.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //classe que representa o banco de dados 
public class Cliente {
	
	@Id // Defini o PrimaryKey da Tabela 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PrimaryKey seja gerado automático
	private Long id;
	
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
