package com.generation.IntegraJa.model;

import java.util.Date;
<<<<<<< Updated upstream

=======
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
>>>>>>> Stashed changes
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< Updated upstream
=======
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
>>>>>>> Stashed changes
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
>>>>>>> Stashed changes
import com.generation.IntegraJa.model.enums.Tema;

/**
 * @author Edgar
 * @version v2
 * @since 27/01/2022 
 * */

<<<<<<< Updated upstream
=======
@Entity
@Table(name = "tb_postagem")
>>>>>>> Stashed changes
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;
	
	@NotNull
	@Size(min = 5,  max = 180)
	private String tituloPost;
	
	@NotNull
	@Size(min = 20, max = 1000)
	private String textoPost;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPost = new java.sql.Date(System.currentTimeMillis());
	
	@Size(min = 10, max = 255)
	private String imagemPost;
	
	@NotNull
	private Long likesPost;
	
	@Enumerated(EnumType.STRING)
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("post")
	private List<Publico> publico;

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

	public List<Publico> getPublico() {
		return publico;
	}

	public void setPublico(List<Publico> publico) {
		this.publico = publico;
	}
		
}
