package com.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.treinamento.domain.Categoria;
import com.treinamento.domain.Cliente;
import com.treinamento.dto.CategoriaDTO;
import com.treinamento.repositories.CategoriaRepository;
import com.treinamento.services.exeptions.DataIntegrityExeption;
import com.treinamento.services.exeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto não encontrado Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
//	public Categoria update(Categoria obj) {
//		find(obj.getId());
//		return repo.save(obj);
//	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExeption("Não é possivel excluir uma categoria que possui produtos.");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO  objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
	
	private void updateData(Categoria newObj,Categoria obj) {
		newObj.setNome(obj.getNome());
	}
 }
