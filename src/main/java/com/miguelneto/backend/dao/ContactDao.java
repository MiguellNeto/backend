package com.miguelneto.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelneto.backend.entidade.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long>{
	
	public Contact findByName(String name);

}
