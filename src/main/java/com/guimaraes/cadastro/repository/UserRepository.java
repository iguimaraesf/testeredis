package com.guimaraes.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import com.guimaraes.cadastro.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long> {
	public Usuario findByCpf(String cpf);
	public Usuario findByCnpj(String cnpj);
}
