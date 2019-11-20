package com.guimaraes.cadastro.model;

import java.time.LocalDate;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Usuario")
public class User {
	public enum Genero { MASCULINO, FEMININO };

	private String id;
	private String nome;
	private String cpf;
	private String senha;
	private Genero genero;
	private LocalDate nascimento;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", genero=" + genero + ", nascimento="
				+ nascimento + "]";
	}
	
	
}
