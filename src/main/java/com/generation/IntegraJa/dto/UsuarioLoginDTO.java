package com.generation.IntegraJa.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Edgar Soares Marinho
 * @version 0.0.1
 * @since 0.0.1 - 04/02/2022 
 * 
 * */
public class UsuarioLoginDTO {
	
	private @NotBlank @Email String email;
	private @NotBlank String senha;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
