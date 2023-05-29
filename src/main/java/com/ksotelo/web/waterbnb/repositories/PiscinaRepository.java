package com.ksotelo.web.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.waterbnb.models.PiscinaModel;

@Repository
public interface PiscinaRepository extends CrudRepository<PiscinaModel, Long>{

	List<PiscinaModel> findByAddress(String address);
}
