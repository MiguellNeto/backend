package com.miguelneto.backend.entidade;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@ManyToOne //um pra muitos AGREGACAO
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP) //dia/mes/ano 
	private Date data;
		
	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true) // COMPOSICAO -nao vive separado coloca cascade- 
										//orphanRemoval - para funcionar o cascade no delete
	@JoinColumn(name="pedido_id") // coluna de junção pq é OnetoMany
	private List<PedidoItem> itens = new ArrayList<>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}
	
}
