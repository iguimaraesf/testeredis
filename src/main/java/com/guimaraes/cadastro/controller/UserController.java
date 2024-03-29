package com.guimaraes.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.cadastro.model.Usuario;
import com.guimaraes.cadastro.service.UserServiceImpl;

@RestController
public class UserController {
	private static final String URL = "/usuario";
	
	@Autowired
	private UserServiceImpl service;

	@PostMapping(path = URL)
	public Usuario novoUsuario(@RequestBody @Valid Usuario user) {
		return service.gravar(user);
	}
	
	@GetMapping(path = URL)
	public Iterable<Usuario> obterTodos() {
		return service.listar();
	}
	
	@DeleteMapping(path = URL + "/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
