package com.guimaraes.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import com.guimaraes.cadastro.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
