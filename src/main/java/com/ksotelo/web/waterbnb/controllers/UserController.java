package com.ksotelo.web.waterbnb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ksotelo.web.waterbnb.models.LoginModel;
import com.ksotelo.web.waterbnb.models.UserModel;
import com.ksotelo.web.waterbnb.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;

	@GetMapping("/guest/signin")
	public String showForms(@ModelAttribute("newUser") UserModel newUser, Model viewModel) {
		viewModel.addAttribute("newUser", new UserModel());
		viewModel.addAttribute("login", new UserModel());
		return "logreg.jsp";
	}

	@PostMapping("/user/new")
	public String newUser(@Valid @ModelAttribute("newUser") UserModel newUser, BindingResult resultado, HttpSession sesion, Model viewModel) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("login", new UserModel());
			return "logreg.jsp";
		}
		
		UserModel userRegistrado = userServ.crearUsuario(newUser, resultado);
		if(userRegistrado!=null) {
			UserModel u = userServ.findByEmail(newUser.getEmail());
			sesion.setAttribute("userId", u.getId());
			return "redirect:/search";
		}
		viewModel.addAttribute("login", new UserModel());
		return "logreg.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LoginModel login, BindingResult result, HttpSession session,
			Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("newUser", new UserModel());
			return"logreg.jsp";
		}
		if(userServ.authenticateUser(login.getEmail(), login.getPassword(), result)) {
			UserModel u = userServ.findByEmail(login.getEmail());
			session.setAttribute("userId", u.getId());
			return "redirect:/host/dashboard";
		}
		viewModel.addAttribute("newUser", new UserModel());
		return"logreg.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.setAttribute("userId", null);
		return"redirect:/";
	}
}
