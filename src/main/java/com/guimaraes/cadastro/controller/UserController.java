package com.guimaraes.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.cadastro.model.User;

@RestController
public class UserController {
	private static final String URL = "/usuario";

	private static final String REDIS_INDEX_KEY = "USUARIO";
	
	@Autowired
	RedisTemplate<String, Object> template;

	@PostMapping(path = URL)
	public String novoUsuario(@RequestBody User user) {
		template.opsForHash().put(REDIS_INDEX_KEY, user.getId(), user);
		return "criado";
	}
	
	@GetMapping(path = URL)
	public ResponseEntity<Object> obterTodos() {
		return new ResponseEntity<Object>(template.opsForHash().entries(REDIS_INDEX_KEY), HttpStatus.OK);
	}
	
	@DeleteMapping(path = URL + "/{id}")
	public void excluir(@PathVariable String id) {
		template.opsForHash().delete(REDIS_INDEX_KEY, id);
	}
}
