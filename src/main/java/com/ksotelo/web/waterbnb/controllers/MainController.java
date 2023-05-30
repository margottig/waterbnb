package com.ksotelo.web.waterbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksotelo.web.waterbnb.models.ComentarioModel;
import com.ksotelo.web.waterbnb.models.PiscinaModel;
import com.ksotelo.web.waterbnb.models.UserModel;
import com.ksotelo.web.waterbnb.services.ComentarioService;
import com.ksotelo.web.waterbnb.services.PiscinaService;
import com.ksotelo.web.waterbnb.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private UserService userServ;
	@Autowired
	private PiscinaService piscinaServ;
	@Autowired
	private ComentarioService comServ;

	@GetMapping("/")
	public String index(HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userId");
		if (userLog == null) {
			return "index.jsp";
		}
		UserModel user = userServ.findById(userLog);
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}

	@GetMapping("/host/dashboard")
	public String host(@ModelAttribute("newPool") PiscinaModel piscina, HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userId");
		if (userLog == null) {
			return "redirect:/guest/signin";
		}
		UserModel usuario = userServ.findById(userLog);
		viewModel.addAttribute("user", usuario);
		return "/host/dashboard.jsp";
	}

	@PostMapping("/new/pool")
	public String newPool(@Valid @ModelAttribute("newPool") PiscinaModel piscina, BindingResult result) {
		if (result.hasErrors()) {
			return "/host/dashboard.jsp";
		}
		piscinaServ.createPiscina(piscina);
		return "redirect:/host/dashboard";
	}

	@GetMapping("/search")
	public String searchForm(HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userId");
		if (userLog == null) {
			return "searchForm.jsp";
		}
		UserModel user = userServ.findById(userLog);
		viewModel.addAttribute("user", user);
		return "searchForm.jsp";
	}

	@PostMapping("/search")
	public String search(@RequestParam(value = "address") String address, Model viewModel, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userId");
		if (address.equals("")) {
			if (userLog == null) { //redirect attribute
				return "searchForm.jsp";
			}
			UserModel user = userServ.findById(userLog);
			viewModel.addAttribute("user", user);
			return "searchForm.jsp";
		}
		if (userLog == null) {
			List<PiscinaModel> piscinas = piscinaServ.findByAddress(address);
			viewModel.addAttribute("piscinas", piscinas);
			return "searchForm.jsp";
		}
		UserModel user = userServ.findById(userLog);
		List<PiscinaModel> piscinas = piscinaServ.findByAddress(address); // Custom Query o contains
		viewModel.addAttribute("piscinas", piscinas);
		viewModel.addAttribute("user", user);
		return "searchForm.jsp";
	}

	@GetMapping("/pools/{idPool}")
	public String findPool(@PathVariable("idPool") Long idPool, Model viewModel, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userId");
		if (userLog == null) {
			PiscinaModel pool = piscinaServ.findById(idPool);
			viewModel.addAttribute("piscina", pool);
			return "showPiscina.jsp";
		}
		UserModel user = userServ.findById(userLog);
		PiscinaModel pool = piscinaServ.findById(idPool);
		viewModel.addAttribute("piscina", pool);
		viewModel.addAttribute("user", user);
		return "showPiscina.jsp";
	}

	@GetMapping("/new/comment/{idPool}")
	public String newComForm(@ModelAttribute("newComment") ComentarioModel newComment, Model viewModel,
			@PathVariable("idPool") Long id) {
		// agregar validacion para evitar que host agregue reviews a sus piscinas
		// Omitir boton/enlace desde jsp para agregar review
		viewModel.addAttribute("piscina", piscinaServ.findById(id));
		return "newComment.jsp";
	}

	@PostMapping("/new/comment/{idPool}")
	public String newCom(@Valid @ModelAttribute("newComment") ComentarioModel newComment, BindingResult result,
			@PathVariable("idPool") Long idPool, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userId");
		if (userLog == null) {
			return "redirect:/guest/signin";
		}
		if (result.hasErrors())
			return "newComment.jsp";
		
		UserModel user = userServ.findById(userLog);
		PiscinaModel piscina = piscinaServ.findById(idPool);
		
		//llamar a un custom query que haga el prodemidio de los ratings/comentarios de una piscina
		// update del registro de la piscina en el campo rating
		
		comServ.addComentario(user, piscina, newComment.getComentario(), newComment.getRating());
		return "redirect:/pools/"+idPool;
	}
//	@PostMapping("/new/comment/{idPool}")
//	public String newComForm(@Valid @ModelAttribute("newComment") ComentarioModel newComment,
//			@PathVariable("idPool") Long id, BindingResult result, Model viewModel, HttpSession sesion) {
//		Long userLog = (Long) sesion.getAttribute("userId");
		
//		if (result.hasErrors()) {
//			return "newComment.jsp";
//		}
//
////
//////		viewModel.addAttribute("piscina", piscinaServ.findById(idPool));
//		return "newComment.jsp";
//	}
	
	// GET Y POST PARA EDICION DE PISCINA DEL HOST!
}
