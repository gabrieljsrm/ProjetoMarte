package br.fiap.app.exemplo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.fiap.app.exemplo.repositories.ViagemRepository;
import jakarta.validation.Valid;
import br.fiap.app.exemplo.models.Viagem;





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
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String Create(@ModelAttribute("infViagem")Viagem objViagem) {
		viagemRepository.save(objViagem);
		return "redirect:/infViagem";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		viagemRepository.deleteById(id);
		return "redirect:/infViagem";
	}
	
	  
	@GetMapping("/edit/{id}")
	public ModelAndView showEditViagemPage(@PathVariable("id") Long id) {
	   ModelAndView mav = new ModelAndView("infViagem/edit");
	   Viagem objViagem = viagemRepository.getById(id);
	   mav.addObject("viagem", objViagem);
	   return mav;
	}


	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("viagem") Viagem viagemAtualizada, BindingResult result) {
	    if (result.hasErrors()) {
	        return "editarViagem";
	    } else {
	        Viagem viagemExistente = viagemRepository.getById(id);
	        viagemExistente.setDataDecolagem(viagemAtualizada.getDataDecolagem());
	        viagemExistente.setDuracaoEstadia(viagemAtualizada.getDuracaoEstadia());
	        viagemExistente.setAssentosDisponiveis(viagemAtualizada.getAssentosDisponiveis());
	        viagemExistente.setNomeModeloNave(viagemAtualizada.getNomeModeloNave());
	        viagemExistente.setNomePrimeiroComandante(viagemAtualizada.getNomePrimeiroComandante());
	        viagemExistente.setMatriculaPrimeiroComandante(viagemAtualizada.getMatriculaPrimeiroComandante());
	        viagemExistente.setNomeSegundoComandante(viagemAtualizada.getNomeSegundoComandante());
	        viagemExistente.setMatriculaSegundoComandante(viagemAtualizada.getMatriculaSegundoComandante());
	        viagemRepository.save(viagemExistente);
	        return "redirect:/infViagem";
	    }
	}

	    
	  
	
	
}
