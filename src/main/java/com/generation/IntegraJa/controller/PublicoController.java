package com.generation.IntegraJa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.generation.IntegraJa.model.Publico;
import com.generation.IntegraJa.repository.PublicoRepository;

/**@author Cesar
 * @version v1
 * @since 27/01/2022 
 * */

public class PublicoController {

	private PublicoRepository repository;
	
	public ResponseEntity<List<Publico>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	public ResponseEntity<Publico> GetById (@PathVariable long idPublico) {
		return repository.findById(idPublico).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
}
