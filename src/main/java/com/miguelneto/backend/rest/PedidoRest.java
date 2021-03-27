package com.miguelneto.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguelneto.backend.dao.PedidoDao;
import com.miguelneto.backend.entidade.Pedido;

@CrossOrigin(origins = "http://localhost:8080") //pode receber requisicoes de multiplas fonte 
@RestController
@RequestMapping("/pedido") // conexao insomia (web service)
public class PedidoRest {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	@GetMapping
	public List<Pedido> get(){
		
		return pedidoDao.findAll();
	}
	
	@PostMapping
	public void post (@RequestBody Pedido pedido) {
		pedidoDao.save(pedido);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(Long id) {
		pedidoDao.deleteById(id);
	}
	
}
