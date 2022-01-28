package com.generation.IntegraJa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.generation.IntegraJa.model.Postagem;
import com.generation.IntegraJa.repository.PostagemRepository;


/**@author Pedro Edilaine
 * @version v2 - Implementação dos métodos AutowiredRepository, GetAll, GetById
 * @since 27/01/2022
 * */

public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idPost}")
	public ResponseEntity<Postagem> GetById (@PathVariable long idPost) {
		return repository.findById(idPost).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
    @PutMapping
    public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }
	
     @DeleteMapping("/{id}")
     public void delete(@PathVariable long id) {
    	 repository.deleteById(id);
     }
}
