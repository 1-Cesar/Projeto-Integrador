package com.generation.IntegraJa.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
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
import com.generation.IntegraJa.dto.UsuarioDTO;
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
	
	public ResponseEntity<UsuarioCredentialsDTO> login (@Valid UsuarioLoginDTO dto) {
		return repository.findByEmailUsuario(dto.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if (encoder.matches(dto.getSenha(), resp.getSenhaUsuario())) {
				credentialsDTO = new UsuarioCredentialsDTO(
						basicTokenGenerator(dto.getEmail(), dto.getSenha()),
						resp.getIdUsuario(),
						resp.getNomeUsuario(),
						resp.getEmailUsuario(),
						resp.getFotoUsuario());
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
	
	public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){
		List<Usuario> usuarios = repository.findAll();
		
		List<UsuarioDTO> usuariosDTOs = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuariosDTOs.add(modelToDTO(usuario));
		}
		
		if (usuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(usuariosDTOs); 
		}
	}
	
	public ResponseEntity<UsuarioDTO> buscarPorID(Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(200).body(modelToDTO(resp)))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});		
	}
	
	public UsuarioDTO modelToDTO (Usuario usuario){

		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getIdUsuario());
		dto.setNome(usuario.getNomeUsuario());
		dto.setEmail(usuario.getEmailUsuario());
		dto.setFoto(usuario.getFotoUsuario());

		return dto;
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

	public ResponseEntity<List<UsuarioDTO>> buscarPorNome(String nome) {
		List<Usuario> usuarios = repository.findAllByNomeUsuarioContainingIgnoreCase(nome);
		
		List<UsuarioDTO> usuariosDTOs = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuariosDTOs.add(modelToDTO(usuario));
		}
		
		if (usuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(usuariosDTOs); 
		}
		
	}
	
}
