package com.ksotelo.web.waterbnb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.waterbnb.models.PiscinaModel;

@Repository
public interface PiscinaRepository extends CrudRepository<PiscinaModel, Long>{

	List<PiscinaModel> findByAddress(String address);
	
	@Query(value = "SELECT AVG(rating) FROM comentarios where piscina_id = :id", nativeQuery = true)
    Optional<Double> obtenerPromedioRatings(Long id);
	
}
