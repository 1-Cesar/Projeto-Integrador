package com.generation.IntegraJa.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.IntegraJa.dto.UsuarioCredentialsDTO;
import com.generation.IntegraJa.dto.UsuarioLoginDTO;
import com.generation.IntegraJa.model.Usuario;
import com.generation.IntegraJa.repository.UsuarioRepository;

/**
 * @author Cesar Augusto
 * @author Pedro Lucas Silvério
 * @author Edgar Soares Marinho
 * @date 04/02/2022
 */

@Service
public class UsuarioService {

	private UsuarioCredentialsDTO credentialsDTO;
	
	@Autowired
	private UsuarioRepository repository;
	
	public ResponseEntity<Usuario> registrar (Usuario novoUsuario) {
		Optional<Usuario> optional = repository.findByEmail(novoUsuario.getEmail());
		
		if(optional.isEmpty()) {
			novoUsuario.setSenha(criptografarSenha(novoUsuario.getSenha()));
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
		}
	}
	
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}
	
	public ResponseEntity<UsuarioCredentialsDTO> login (@Valid UsuarioLoginDTO dto) {
		return repository.findByEmail(dto.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if (encoder.matches(dto.getSenha(), resp.getSenha())) {
				credentialsDTO = new UsuarioCredentialsDTO(
						basicTokenGenerator(dto.getEmail(), dto.getSenha()),
						resp.getId(),
						resp.getNome(),
						resp.getEmail(),
						resp.getFoto(),
						resp.getTipo());
				return ResponseEntity.status(HttpStatus.OK).body(credentialsDTO);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha Inválida!");
			}
			
		}).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe!");
		});
		
	}

	private String basicTokenGenerator(String email, String senha) {
		String structure = email + ":" + senha;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(structureBase64);
	}
	
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> usuarios = repository.findAll();
			
		if (usuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(usuarios); 
		}
	}
	
	public ResponseEntity<Usuario> buscarPorID(Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});		
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteUsuario(Long id) {
		Optional<Usuario> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.status(200).build();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		}
	}

	public ResponseEntity<List<Usuario>> buscarPorNome(String nome) {
		List<Usuario> usuarios = repository.findAllByNomeContainingIgnoreCase(nome);
			
		if (usuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(usuarios); 
		}
		
	}
	
	public ResponseEntity<Usuario> atualizar (Usuario modificado){
		Optional <Usuario> optional = repository.findById(modificado.getId());
		
		if(optional.isPresent()) {
			modificado.setSenha(optional.get().getSenha());
			return ResponseEntity.status(200).body((repository.save(modificado)));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		}
	}
}
