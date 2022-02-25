package com.generation.IntegraJa.dto;

/**
 * @author Pedro Lucas Silvério
 * @version 0.0.1
 * @since 0.0.1 - 04/02/2022 
 * 
 * */

public class UsuarioCredentialsDTO {

	private String basicToken;
	private Long id;
	private String nome;
	private String email;
	private String foto;
	
	public UsuarioCredentialsDTO(String basicToken, Long id, String nome, String email, String foto) {
		this.basicToken = basicToken;
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.foto = foto;
	}

	public String getBasicToken() {
		return basicToken;
	}

	public void setBasicToken(String basicToken) {
		this.basicToken = basicToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
