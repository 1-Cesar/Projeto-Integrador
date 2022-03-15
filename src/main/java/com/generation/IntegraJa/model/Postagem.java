package com.generation.IntegraJa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Edgar Soares Marinho
 * @version 0.0.1
 * @since 0.0.1 - 27/01/2022
 */

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;

	@NotNull
	@Size(min = 5, max = 180)
	private String tituloPost;

	@Size(max = 5000)
	private String textoPost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPost = new java.sql.Date(System.currentTimeMillis());

	@Size(min = 10, max = 5000)
	private String imagemPost;

	@NotNull
	private Long likesPost;

	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Usuario usuario;

	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getTituloPost() {
		return tituloPost;
	}

	public void setTituloPost(String tituloPost) {
		this.tituloPost = tituloPost;
	}

	public String getTextoPost() {
		return textoPost;
	}

	public void setTextoPost(String textoPost) {
		this.textoPost = textoPost;
	}

	public Date getDataPost() {
		return dataPost;
	}

	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}

	public String getImagemPost() {
		return imagemPost;
	}

	public void setImagemPost(String imagemPost) {
		this.imagemPost = imagemPost;
	}

	public Long getLikesPost() {
		return likesPost;
	}

	public void setLikesPost(Long likesPost) {
		this.likesPost = likesPost;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}