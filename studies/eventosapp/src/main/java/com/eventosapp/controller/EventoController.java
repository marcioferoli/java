package com.eventosapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.model.Evento;
import com.eventosapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@RequestMapping("/eventos")
	public ModelAndView listar() {
		Iterable<Evento> eventos = eventoRepository.findAll();

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("eventos", eventos);
		return modelAndView;
	}

	@RequestMapping(value = "/eventoCadastrar", method = RequestMethod.GET)
	public String cadastrarForm() {
		return "evento/cadastrar";
	}

	@RequestMapping(value = "/eventoCadastrar", method = RequestMethod.POST)
	public String cadastrarSave(Evento evento) {
		eventoRepository.save(evento);
		return "redirect:/eventoCadastrar";
	}

	@RequestMapping("/{codigo}")
	public ModelAndView detalhar(@PathVariable("codigo") long codigo) {
		Evento evento = eventoRepository.findByCodigo(codigo);

		ModelAndView modelAndView = new ModelAndView("evento/detalhar");
		modelAndView.addObject("evento", evento);
		return modelAndView;
	}

}
