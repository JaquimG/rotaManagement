package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Rota;

import com.example.demo.service.RotaService;

@RestController
@RequestMapping(value = "/rotas")
public class RotaController {
	
	@Autowired
	RotaService rotaService;
	
	// Usa o serviço que lista todas as rotas existentes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Rota>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(rotaService.searchAll());
	}
	
	// Usa o serviço que cria Rota
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Rota rota) {
		rota = rotaService.create(rota);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(rota.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// Usa o serviço que busca rota por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Optional<Rota> rota = rotaService.search(id);
		CacheControl cacheControl = CacheControl.maxAge(200, TimeUnit.SECONDS);  // Utilização da cache
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(rota);
	}
	
	// Usa o serviço que deleta uma rota
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		rotaService.delete(id);
		return ResponseEntity.noContent().build(); // Garante a corretude do código http
	}
	
	// Usa o serviço que atualiza uma rota
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> deletar(@RequestBody Rota rota,@PathVariable("id") Long id) {
		rota.setId(id);
		rotaService.update(rota);
		return ResponseEntity.noContent().build();
	}
	



	// Usa o serviço que modifica o status da rota
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> modificaStats(@PathVariable("id") Long id) {
		rotaService.modifyStats(id);
		
		return ResponseEntity.noContent().build();
	}
}
