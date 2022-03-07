package com.generation.IntegraJa.repository;

import com.generation.IntegraJa.model.Tema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**@author Pedro Lucas
 * @version 0.0.1
 * @since 0.0.1 - 27/01/2022 
 * */

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{}
