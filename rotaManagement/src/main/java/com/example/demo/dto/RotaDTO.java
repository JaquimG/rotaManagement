package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Rota;
import com.example.demo.domain.Stop;


// UTILIZAR CASO DÊ TEMPO DE TERMINAR
public class RotaDTO {
	
	private String assignedVehicle;
	private List<Stop> plannedStops;
	
	
	
	public Rota rotaTransformer(Rota rota) {
		return new Rota(rota.getAssignedVehicle(), rota.getPlannedStops());
	}
	
	public String getAssignedVehicle() {
		return assignedVehicle;
	}
	public void setAssignedVehicle(String assignedVehicle) {
		this.assignedVehicle = assignedVehicle;
	}
	public List<Stop> getPlannedStops() {
		return plannedStops;
	}
	public void setPlannedStops(List<Stop> plannedStops) {
		this.plannedStops = plannedStops;
	}
	
	
}
