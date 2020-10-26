package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {

		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Nome1x");
		cliente1.setEmail("Email1");
		cliente1.setTelefone("Telefone1");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Nome2");
		cliente2.setEmail("Email2");
		cliente2.setTelefone("Telefone2");
		
		return Arrays.asList(cliente1, cliente2);
	}
	
}
