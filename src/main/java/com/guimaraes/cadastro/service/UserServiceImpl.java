package com.guimaraes.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimaraes.cadastro.model.User;
import com.guimaraes.cadastro.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository repository;
	public User gravar(User usuario) {
		return repository.save(usuario);
	}
	
	public Iterable<User> listar() {
		return repository.findAll();
	}
	
	public void excluir(String id) {
		repository.deleteById(id);
	}
}
