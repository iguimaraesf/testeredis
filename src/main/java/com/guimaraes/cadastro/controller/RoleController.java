package com.guimaraes.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.cadastro.model.Papel;
import com.guimaraes.cadastro.service.RoleServiceImpl;

@RestController
public class RoleController {

	private static final String URL = "/papel";

	@Autowired
	private RoleServiceImpl service;
	
	@PostMapping(path = URL)
	public Papel novoPapel(@RequestBody @Valid Papel user) {
		return service.gravar(user);
	}
	
	@GetMapping(path = URL)
	public Iterable<Papel> obterTodos() {
		return service.listar();
	}
	
	@DeleteMapping(path = URL + "/{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}


}
