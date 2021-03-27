package com.miguelneto.backend.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelneto.backend.entidade.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long>{

}
