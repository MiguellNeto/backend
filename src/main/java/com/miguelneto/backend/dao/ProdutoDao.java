package com.miguelneto.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelneto.backend.entidade.Produto;

@Repository //com o extends JpaRepository vem com varios métodos pronto que faz o cred funcionar 
public interface ProdutoDao extends JpaRepository<Produto, Long>{ 

}
