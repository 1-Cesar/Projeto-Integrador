package com.generation.IntegraJa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Cesar Augusto
 * @author Edgar Soares Marinho
 * @version 0.0.2
 * @since 0.0.1 - 26/01/2022 
 * 
 * */

@Entity
@Table (name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTema;
	
	@NotNull
	private String descTema;
		
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = {"tema"}, allowSetters = true)
	private List<Postagem> postagens;

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getDescTema() {
		return descTema;
	}

	public void setDescTema(String descTema) {
		this.descTema = descTema;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	
}
