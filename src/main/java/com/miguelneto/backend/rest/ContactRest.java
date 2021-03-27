package com.miguelneto.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.miguelneto.backend.dao.ContactDao;

import com.miguelneto.backend.entidade.Contact;



@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactRest {

	@Autowired
	private ContactDao contactDao;
	
	@GetMapping
	public List<Contact> get(){
		
		return contactDao.findAll();
	}
	
	@PostMapping
	public void post (@RequestBody Contact contact) {
		contactDao.save(contact);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		contactDao.deleteById(id);
	}
	
	
}
