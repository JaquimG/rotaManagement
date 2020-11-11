package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Rota;
import com.example.demo.domain.Stop;
import com.example.demo.repository.RotaRepository;
import com.example.demo.repository.StopRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RotaService {
	
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private StopRepository stopRepository;
	
	
	public Rota create(Rota rota) {
		rota.setStats("pendente");
		return rotaRepository.save(rota);
	}
	
	public Optional<Rota> search(Long id) {
		Optional<Rota> rota = rotaRepository.findById(id);
		return rota;
	}
	
	public List<Rota> searchAll(){
		List<Rota> rota = rotaRepository.findAll();
		return rota;
	}
	
	public void checkExistence(Rota rota) {
		search(rota.getId());	
	}

	public Rota update(Rota rota) {
		  checkExistence(rota);
		  return rotaRepository.save(rota);
	}
	
	public void delete(Long id){
		Optional<Rota> rota = search(id);
		Rota r = rota.get();
		rotaRepository.delete(r);
	}
	
	
	// Adiciona stop em uma rota
	public Stop addStop(Long id, Stop stop) {
		Optional<Rota> rota = rotaRepository.findById(id);
		Rota r = rota.get();
		r.getPlannedStops().add(stop);
		return stop;
	}
	
	// Captura o stop com raio de entrega mais próximo na List
	public Stop catchMinor(Rota rota) {
		List<Stop> stop = rota.getPlannedStops();
		int minor;
		Stop maiorStop = null;
		for(int i=0; i<stop.size();i++) {
			Stop s = stop.get(i);
			Stop s2 = stop.get(i++);
			if(s.getDeliveryRadius() > s2.getDeliveryRadius()) {
				minor = s2.getDeliveryRadius();
				maiorStop = s2;
			}else {
				minor = s.getDeliveryRadius();
				maiorStop = s;
			}
		
		}
		return maiorStop;
		
		
	}
	
	// Verifica se ainda existe stop na rota
	public Boolean isNull(Rota rota) {
		if(rota.getPlannedStops()==null) {
			return true;
		}
		return false;
		
	}
	
	// Deleta stop com raio de entrega masi próximo da rota e a prórpria rota caso não tenha mais stop
	public void deleteStop(Rota rota, Stop stop) {
		stop = catchMinor(rota);
		stopRepository.delete(stop);
		if(isNull(rota)) {
			rotaRepository.delete(rota);
		}
	}

	// Muda o status da rota
	public void modifyStats(Long id) {
		Optional<Rota> rota = search(id);
		Rota r = rota.get();
		if(!isNull(r)) {
			r.setStats("Finalizada");
		}
	}


}
