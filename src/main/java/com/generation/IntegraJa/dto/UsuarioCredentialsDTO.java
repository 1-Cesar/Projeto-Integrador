package com.generation.IntegraJa.dto;

public class UsuarioCredentialsDTO {

	
	private String basicToken;
	private Long id;
	private String email;
	
	public UsuarioCredentialsDTO(String basicToken, Long id, String email) {
		this.basicToken = basicToken;
		this.id = id;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
