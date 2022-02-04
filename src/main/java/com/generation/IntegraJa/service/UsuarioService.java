package com.generation.IntegraJa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.IntegraJa.dto.UsuarioCredentialsDTO;
import com.generation.IntegraJa.model.Usuario;
import com.generation.IntegraJa.repository.UsuarioRepository;

/**
 * @author Cesar Augusto
 * @date 04/02/2022
 */

@Service
public class UsuarioService {

	private UsuarioCredentialsDTO credentialsDTO;
	
	@Autowired
	private UsuarioRepository repository;
	
	public ResponseEntity<Usuario> registrar (Usuario novoUsuario) {
		Optional<Usuario> optional = repository.findByEmailUsuario(novoUsuario.getEmailUsuario());
		
		if(optional.isEmpty()) {
			novoUsuario.setSenhaUsuario(criptografarSenha(novoUsuario.getSenhaUsuario()));
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
		}
	}
	
	private String criptografarSenha(String senhaUsuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senhaUsuario);
	}
	
}
