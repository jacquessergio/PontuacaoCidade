package com.teste.spring.controller.domain;

import javax.validation.constraints.Size;

public class Regiao {

	@Size(min=3, message="* Para pesquisar, o campo Cidade não pode estar em branco e deve conter no mínimo 3 caracteres")
	private String Nome;
	private String Estado;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
}
