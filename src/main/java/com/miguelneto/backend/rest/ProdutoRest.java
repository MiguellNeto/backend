package com.miguelneto.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguelneto.backend.dao.ProdutoDao;
import com.miguelneto.backend.entidade.Produto;



@RestController
@RequestMapping("/produto")
public class ProdutoRest {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@GetMapping
	public List<Produto> get(){
		return produtoDao.findAll(); //findAll retorna todos 
	}
	
	@PostMapping // Aceita retornar valores
	public void post(@RequestBody Produto produto) {
		produtoDao.save(produto); // save altera
	}
	
//	@PutMapping // Não aceita retornar valores
//	public void put(@RequestBody Produto produto) {
//		produtoDao.save(produto); // save altera
//	}

	@DeleteMapping("/{id}")
	public void delete(Long id) {
		produtoDao.deleteById(id);
	}
}
