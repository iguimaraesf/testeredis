package com.guimaraes.cadastro.model;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Papel")
public class Papel {
	@Id
	private Integer id;
	@NotEmpty
	private String nome;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Papel [id=" + id + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Papel))
			return false;
		Papel other = (Papel) obj;
		return Objects.equals(id, other.id);
	}

	
}
