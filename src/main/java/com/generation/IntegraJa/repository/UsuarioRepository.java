package com.generation.IntegraJa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.IntegraJa.model.Usuario;

/**
 * @author Pedro Lucas
 * @version 0.0.1
 * @since 0.0.1 - 26/01/2022 
 * 
 * */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase (String nomeUsuario);

}