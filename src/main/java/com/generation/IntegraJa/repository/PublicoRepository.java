package com.generation.IntegraJa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.IntegraJa.model.Publico;

/**@author Pedro Lucas
 * @version 0.0.1
 * @since 0.0.1 - 27/01/2022 
 * */

@Repository
public interface PublicoRepository extends JpaRepository<Publico, Long>{}
