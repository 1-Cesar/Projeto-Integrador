package com.generation.IntegraJa.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.generation.IntegraJa.dto.UsuarioCredentialsDTO;
import com.generation.IntegraJa.dto.UsuarioDTO;
import com.generation.IntegraJa.dto.UsuarioLoginDTO;
import com.generation.IntegraJa.model.Usuario;
import com.generation.IntegraJa.repository.UsuarioRepository;
import com.generation.IntegraJa.service.UsuarioService;


/**
 * @author Cesar Augusto
 * @author Edgar Soares Marinho
 * @author Pedro Lucas
 * @author Edilaine Souza
 * @version 0.0.1
 * @since 0.0.1 - 26/01/2022
 * 
 * Implementa o CRUD da UsuarioController
 *
 * */


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired UsuarioService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrar (@RequestBody Usuario usuario){
		return service.registrar(usuario);
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioCredentialsDTO> login (@Valid @RequestBody UsuarioLoginDTO usuario){
		return service.login(usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAllUsuarios () {
		return service.getAllUsuarios();
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> getUsuarioById (@PathVariable Long idUsuario) {
		return service.buscarPorID(idUsuario);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioDTO>> getUsuarioByNome (@PathVariable String nome) {
		return service.buscarPorNome(nome);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable long id) {
		service.deleteUsuario(id);
	}
	
}
