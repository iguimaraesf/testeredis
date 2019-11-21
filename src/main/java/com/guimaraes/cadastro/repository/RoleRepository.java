package com.guimaraes.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import com.guimaraes.cadastro.model.Papel;

public interface RoleRepository extends CrudRepository<Papel, Integer> {

}
