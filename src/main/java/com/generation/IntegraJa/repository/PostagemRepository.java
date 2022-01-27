package com.generation.IntegraJa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.IntegraJa.model.Postagem;

/**@author Pedro / Edilaine
 * @version v2
 * @since 27/01/2022 
 * */

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List<Postagem> findAllByTituloPostContainingIgnoreCase (String tituloPost);
	public List<Postagem> findAllByTemaPostContainingIgnoreCase   (String tema);
}
