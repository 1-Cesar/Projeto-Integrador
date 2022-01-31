package com.generation.IntegraJa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.IntegraJa.model.Postagem;
import com.generation.IntegraJa.repository.PostagemRepository;

/**
 * @author Pedro Lucas
 * @author Edilaine Souza
 * @version 0.0.1
 * @since 0.0.1 - 27/01/2022
 * 
 * Injeção de dependência do repository e implementação dos endpoints pros métodos getAll, getById, put e delete.
 * 
 * */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/postagem")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAllPostagens() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idPost}")
	public ResponseEntity<Postagem> getPostagemById (@PathVariable long idPost) {
		return repository.findById(idPost)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// getPostagemByTitulo() - GET request
	
	// createPostagem() - POST request
	
    @PutMapping
    public ResponseEntity<Postagem> updatePostagem (@RequestBody Postagem postagem){
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(repository.save(postagem));
    }
	
     @DeleteMapping("/{id}")
     public void deletePostagem(@PathVariable long id) {
    	 repository.deleteById(id);
     }
     
}
