package com.generation.IntegraJa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.IntegraJa.model.Publico;
import com.generation.IntegraJa.repository.PublicoRepository;

/**@author Cesar Augusto
 * @author Edgar Soares Marinho
 * @version 0.0.1
 * @since 0.0.1 - 27/01/2022 
 * 
 * Injeção de dependência do repository e implementação dos métodos getAll, getbyId, createNew, update e delete.
 * 
 * */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/publico")
public class PublicoController {

	@Autowired
	private PublicoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Publico>> getAllPublico() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idPublico}")
	public ResponseEntity<Publico> getPublicoById (@PathVariable long idPublico) {
		return repository.findById(idPublico)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Publico> createNewPublico(@RequestBody Publico publico){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(repository.save(publico));
	}
	
	@PutMapping
	public ResponseEntity<Publico> updatePublico(@RequestBody Publico publico){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(publico));
	}
	
	@DeleteMapping("/{id}")
	public void deletePublico(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
