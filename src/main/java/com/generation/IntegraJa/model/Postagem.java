package com.generation.IntegraJa.model;

import java.util.Date;

import com.generation.IntegraJa.model.enums.Tema;

public class Postagem {
	
	private Long idPost;
	
	private String tituloPost;
	
	private String textoPost;
	
	private Date dataPost = new java.sql.Date(System.currentTimeMillis());
	
	private String imagemPost;
	
	private Long likesPost;
	
	private Tema tema;
	
	private Usuario usuario;

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

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
