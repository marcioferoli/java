package com.eventosapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.model.Convidado;
import com.eventosapp.model.Evento;
import com.eventosapp.repository.ConvidadoRepository;
import com.eventosapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@RequestMapping("/eventos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("evento/listar");

		Iterable<Evento> eventos = eventoRepository.findAll();
		modelAndView.addObject("eventos", eventos);

		return modelAndView;
	}

	@RequestMapping(value = "/eventoCadastrar", method = RequestMethod.GET)
	public String cadastrarGet() {
		return "evento/cadastrar";
	}

	@RequestMapping(value = "/eventoCadastrar", method = RequestMethod.POST)
	public String cadastrarPost(Evento evento) {
		eventoRepository.save(evento);
		return "redirect:/eventoCadastrar";
	}

	@RequestMapping(value = "/eventoDetalhar/{eventoCodigo}", method = RequestMethod.GET)
	public ModelAndView detalharGet(@PathVariable("eventoCodigo") Long eventoCodigo) {
		Evento evento = eventoRepository.findByCodigo(eventoCodigo);

		ModelAndView modelAndView = new ModelAndView("evento/detalhar");
		modelAndView.addObject("evento", evento);

		Iterable<Convidado> convidados = evento.getConvidados();
		modelAndView.addObject("convidados", convidados);

		return modelAndView;
	}

	@RequestMapping(value = "/eventoDetalhar/{eventoCodigo}", method = RequestMethod.POST)
	public String detalharPost(@PathVariable("eventoCodigo") Long eventoCodigo, Convidado convidado) {
		convidadoRepository.save(convidado);

		Evento evento = eventoRepository.findByCodigo(eventoCodigo);
		evento.getConvidados().add(convidado);
		eventoRepository.save(evento);

		return "redirect:/eventoDetalhar/{eventoCodigo}";
	}

}
