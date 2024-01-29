package com.treinamento.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listar() {
		Categoria categoria = new Categoria();
		categoria.setNome("Informatica");
		
		Categoria categoria2 = new Categoria();
		categoria2.setNome("Material de Venda");
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(categoria);
		categorias.add(categoria2);
		
		for (Categoria cat : categorias) {
			System.out.println(cat);
		}
		
		return categorias;
	}
	
	

}
