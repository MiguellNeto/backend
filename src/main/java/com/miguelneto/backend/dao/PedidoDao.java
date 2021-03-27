package com.miguelneto.backend.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelneto.backend.entidade.Pedido;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Long>{
	
	
}
