package com.guimaraes.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimaraes.cadastro.model.Papel;
import com.guimaraes.cadastro.repository.RoleRepository;

@Service
public class RoleServiceImpl {

	@Autowired
	private RoleRepository repository;

	public Papel gravar(Papel papel) {
		return repository.save(papel);
	}

	public Iterable<Papel> listar() {
		return repository.findAll();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
