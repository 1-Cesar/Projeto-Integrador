package com.generation.IntegraJa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Cesar Augusto
 * @author Edgar Soares Marinho
 * @version 0.0.1
 * @since 0.0.1 - 26/01/2022 
 * 
 * */

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String nomeUsuario;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String telefoneUsuario;
	
	@NotNull
	@Email
	@Size(min = 5, max = 100)
	private String emailUsuario;
	
	@NotNull
	@Size(min = 8, max = 255)
	private String senhaUsuario;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String fotoUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagens;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public String getFotoUsuario() {
		return fotoUsuario;
	}
	
	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}
	
	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}
	
	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	
	public List<Postagem> getPostagens() {
		return postagens;
	}
	
	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
		
}
