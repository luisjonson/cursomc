package com.treinamento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.domain.Cliente;
import com.treinamento.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente categoria = service.find(id);
		
		if(categoria != null) {
			return ResponseEntity.ok().body(categoria);
		}
		return null;
//		Cliente categoria = new Cliente();
//		categoria.setNome("Informatica");
//		
//		Cliente categoria2 = new Cliente();
//		categoria2.setNome("Material de Venda");
//		
//		List<Cliente> categorias = new ArrayList<>();
//		categorias.add(categoria);
//		categorias.add(categoria2);
//		
//		for (Cliente cat : categorias) {
//			System.out.println(cat);
//		}
		
//		return categorias;
	}
	
	

}
