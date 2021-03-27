package com.miguelneto.backend.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	
	private String description;
	
	private String email;
	
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Long id, String name, String description, String email) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.email = email;
	}

	public void setId(Long id) { //usado somente para tes JUnit
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	

}
