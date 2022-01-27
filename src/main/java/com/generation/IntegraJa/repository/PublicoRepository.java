package com.generation.IntegraJa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.IntegraJa.model.Publico;

/**@author Pedro
 * @version v2
 * @since 27/01/2022 
 * */

@Repository
public interface PublicoRepository extends JpaRepository<Publico, Long>{

}
