package com.treinamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.domain.Pedido;
import com.treinamento.repositories.PedidoRepository;
import com.treinamento.services.exeptions.ObjectNotFoundExeption;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto não encontrado Id:" + id + ", Tipo: " + Pedido.class.getName()));
	}
}
