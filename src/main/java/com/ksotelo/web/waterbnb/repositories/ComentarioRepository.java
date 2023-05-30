package com.ksotelo.web.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.waterbnb.models.ComentarioModel;

@Repository
public interface ComentarioRepository extends CrudRepository<ComentarioModel, Long> {

	
}
