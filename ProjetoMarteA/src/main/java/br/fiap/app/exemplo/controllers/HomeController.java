package br.fiap.app.exemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model ) {
		model.addAttribute("mensagem", "Bem vindo a Marte");
	
		
		return "home";
	}

}
