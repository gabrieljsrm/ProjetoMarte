package br.fiap.app.exemplo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.fiap.app.exemplo.repositories.ViagemRepository;
import br.fiap.app.exemplo.models.Viagem;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/infViagem")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository; 
	
	@GetMapping("")
	public ModelAndView Get() {
		ModelAndView model = new ModelAndView("infViagem/index");
		List<Viagem> listViagem = viagemRepository.findAll();
		model.addObject("viagens", listViagem);
		return model; 
	}
	
	@GetMapping("/create")
	public ModelAndView Create() {
		ModelAndView model = new ModelAndView("infViagem/create");
		return model; 
	}
	
	@PostMapping("/create")
	public String Create(@ModelAttribute("infViagem")Viagem objViagem) {
		viagemRepository.save(objViagem);
		return "redirect:/infViagem";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		viagemRepository.deleteById(id);
		return "redirect:/infViagem";
	}
	
	@GetMapping("/edit")
	public ModelAndView teste() {
		ModelAndView model = new ModelAndView("infViagem/edit");
		return model; 
	}		
	
	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id")Integer idViagem) {
		model.addAttribute("idViagem", idViagem);
		return "infViagem/edit";
	}
	
	
}
