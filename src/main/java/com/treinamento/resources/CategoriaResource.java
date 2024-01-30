package com.treinamento.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.domain.Categoria;
import com.treinamento.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Optional<Categoria> categoria = service.buscar(id);
		
		if(categoria.isPresent()) {
			return ResponseEntity.ok().body(categoria);
		}
		return null;
//		Categoria categoria = new Categoria();
//		categoria.setNome("Informatica");
//		
//		Categoria categoria2 = new Categoria();
//		categoria2.setNome("Material de Venda");
//		
//		List<Categoria> categorias = new ArrayList<>();
//		categorias.add(categoria);
//		categorias.add(categoria2);
//		
//		for (Categoria cat : categorias) {
//			System.out.println(cat);
//		}
		
//		return categorias;
	}
	
	

}
