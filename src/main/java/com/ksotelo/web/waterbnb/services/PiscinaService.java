package com.ksotelo.web.waterbnb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.waterbnb.models.PiscinaModel;
import com.ksotelo.web.waterbnb.repositories.PiscinaRepository;

@Service
public class PiscinaService {
	@Autowired
	private PiscinaRepository piscinaRepo;

	public PiscinaModel createPiscina(PiscinaModel newPiscina) {
		return piscinaRepo.save(newPiscina);
	}
	
	public List<PiscinaModel> findByAddress(String address){
		return piscinaRepo.findByAddress(address);
	}
	public PiscinaModel findById(Long id) {
		return piscinaRepo.findById(id).orElse(null);
	}
	
	public Double obtenerPromedioRatings(Long id) {
		return piscinaRepo.obtenerPromedioRatings(id).orElse(0.0);
	}
	
	public PiscinaModel actualizarPiscina(PiscinaModel newPiscina) {
		return piscinaRepo.save(newPiscina);
	}
	
	
}
