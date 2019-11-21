package com.guimaraes.cadastro.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimaraes.cadastro.exception.CnpjJaCadastradoException;
import com.guimaraes.cadastro.exception.CpfJaCadastradoException;
import com.guimaraes.cadastro.model.Usuario;
import com.guimaraes.cadastro.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository repository;
	public Usuario gravar(Usuario usuario) {
		this.garantirCpfDiferente(usuario);
		this.garantirCnpjDiferente(usuario);
		if (usuario.getId() == null) {
			usuario.setDataCadastro(LocalDateTime.now());
		} else {
			Optional<Usuario> anterior = repository.findById(usuario.getId());
			if (anterior.isPresent()) {
				usuario.setDataAtualizacao(LocalDateTime.now());
				usuario.setDataCadastro(anterior.get().getDataCadastro());
			} else {
				usuario.setDataCadastro(LocalDateTime.now());
			}
		}
		return repository.save(usuario);
	}
	
	public Iterable<Usuario> listar() {
		return repository.findAll();
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	private void garantirCpfDiferente(Usuario usuario) {
		Usuario uBase = repository.findByCpf(usuario.getCpf());
		if (uBase != null && !uBase.getId().equals(usuario.getId())) {
			throw new CpfJaCadastradoException();
		}
	}
	
	private void garantirCnpjDiferente(Usuario usuario) {
		if (usuario.getCnpj() == null) return;
		Usuario uBase = repository.findByCnpj(usuario.getCnpj());
		if (uBase != null && !uBase.getId().equals(usuario.getId())) {
			throw new CnpjJaCadastradoException();
		}
	}
}
