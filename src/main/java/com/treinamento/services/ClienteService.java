package com.treinamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.domain.Cliente;
import com.treinamento.repositories.ClienteRepository;
import com.treinamento.services.exeptions.ObjectNotFoundExeption;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto não encontrado Id:" + id + ", Tipo: " + Cliente.class.getName()));
	}
}
