package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Rota;
import com.example.demo.domain.Stop;
import com.example.demo.service.RotaService;

@RestController
@RequestMapping(value = "/stops")
public class StopController {
	
		@Autowired
		RotaService rotaService;
		
	// Usa o serviço que cria Stop para uma rota
		@RequestMapping(value = "/{id}", method = RequestMethod.POST)
		public ResponseEntity<Void> criarStop(@PathVariable("id") Long id, @RequestBody Stop stop) {
			stop = rotaService.addStop(id, stop);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.build().toUri();  // gera url a ser utilizada no header
			
			return ResponseEntity.created(uri).build();
		}
		
		// Usa o serviço que deleta uma stop
		@RequestMapping(method = RequestMethod.DELETE)
		public ResponseEntity<Void> deletarStop(@RequestBody Rota rota, @RequestBody Stop stop) {
			rotaService.deleteStop(rota, stop);
			return ResponseEntity.noContent().build(); 
		}

}
