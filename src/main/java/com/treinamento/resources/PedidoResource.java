package com.treinamento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.domain.Pedido;
import com.treinamento.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	@Autowired
	private PedidoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido categoria = service.find(id);
		
		if(categoria != null) {
			return ResponseEntity.ok().body(categoria);
		}
		return null;
//		Pedido categoria = new Pedido();
//		categoria.setNome("Informatica");
//		
//		Pedido categoria2 = new Pedido();
//		categoria2.setNome("Material de Venda");
//		
//		List<Pedido> categorias = new ArrayList<>();
//		categorias.add(categoria);
//		categorias.add(categoria2);
//		
//		for (Pedido cat : categorias) {
//			System.out.println(cat);
//		}
		
//		return categorias;
	}
	
	

}
