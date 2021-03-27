package com.miguelneto.backend;
/*
Pegar o projeto 
Configurar o JUnit no projeto.
Criar 6 testes unitários para o Projeto.
Compactar o projeto com os testes unitários e postar como entrega desta atividade.
A atividade é individual, ou seja, cada aluno terá que fazer o seu e realizar a entrega
 * 
*/

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import java.util.List;

import javax.persistence.Convert;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.miguelneto.backend.dao.ContactDao;
import com.miguelneto.backend.entidade.Contact;
import com.sun.source.tree.AssertTree;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestCrud {
	
	@Autowired
	private ContactDao repo;
	
	@Test
	@Rollback(false) //anotação de teste que é usada para indicar se uma transação gerenciada por teste deve ser revertida após a conclusão do método de teste.
	public void testCreateContact() {
		
		System.out.println("Testando Save !!!");
		Contact contact = new Contact(); 
		contact.setName("Miguel");
		contact.setDescription("Testando JUNIT");
		contact.setEmail("mig@gmail.com");
		
		Contact saveContact = repo.save(contact);
		
		assertNotNull(saveContact); //parâmetro passado não deve ser nulo": se for nulo, o teste do caso falha.
		
	}
	
	@Test 
	public void testFindContactByName() {
		System.out.println("Testando Find existente!!!");
		String name = "Miguel";
		Contact contact = repo.findByName(name);
		
		assertThat(contact.getName()).isEqualTo(name); //passa um objeto Matcher como parâmetro 
		
	}
	
	@Test 
	public void testFindContactByNameNotExist() {
		System.out.println("Testando Find inexistente !!!");
		String name = "Miguelito";
		Contact contact = repo.findByName(name);
		assertNull(contact); //verificar se um objeto é nulo.
		
	}
	
	
	@Test
	@Rollback(false)
	public void testUpdateContact() {
		System.out.println("Testando Update !!!");
		String contactName = "Miguel Alterado JUnit";
		String contactDesc = "Descricao Alterado JUnit";
		String contactEmail = "mig@gmail Alterado JUnit";
		
		Contact contact = new Contact(null, contactName, contactDesc, contactEmail);
		
		contact.setId((long) 36); // id banco de dados 
		
		repo.save(contact);
		
		Contact updateContact = repo.findByName(contactName);
		
		assertThat(updateContact.getName()).isEqualTo(contactName); 
	}
	
	@Test
	@Convert
	public void testListContact() {
		System.out.println("Testando Lista Contatos do Banco de Dados para o console do Eclipse!!!");
		List<Contact> contacts = (List<Contact>) repo.findAll();	
		
		for (Contact contact : contacts) { //pecorre lista de contatos
			System.out.println( "ID: " + contact.getId() + "  Nome: " + contact.getName() + "  E-mail: " + contact.getEmail() +  "  Descricao: " + contact.getDescription()); // lista todos no console
		}
		
		assertThat(contacts).size().isGreaterThan(0);
	
	}
	

	@Test
	@Rollback(false)
	public void testDeleteContact() {
		System.out.println("Testando Delete por ID !!!");
		Long id = (long) 45; // id bando de Dados
		boolean idExiste = repo.findById(id).isPresent(); //Se um valor estiver presente, executa a ação no valor, caso contrário, não faz nada.
		repo.deleteById(id); //açao deletar
		boolean idNaoExiste = repo.findById(id).isPresent();
		
		assertTrue(idExiste);
		assertFalse(idNaoExiste);
	}
	
	
	

	
	// https://www.guru99.com/junit-assert.html consulta assert
}
