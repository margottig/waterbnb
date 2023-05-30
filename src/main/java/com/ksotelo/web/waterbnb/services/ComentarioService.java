package com.ksotelo.web.waterbnb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.waterbnb.models.ComentarioModel;
import com.ksotelo.web.waterbnb.models.PiscinaModel;
import com.ksotelo.web.waterbnb.models.UserModel;
import com.ksotelo.web.waterbnb.repositories.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepo;
	
	public void addComentario(UserModel usuario, PiscinaModel piscina, String comentario, int rating) {
		ComentarioModel msj = new ComentarioModel(comentario, usuario, rating, piscina);
		comentarioRepo.save(msj);
	}
}
