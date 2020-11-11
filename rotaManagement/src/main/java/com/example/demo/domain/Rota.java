package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String assignedVehicle;
	private String stats;
	
	
	@OneToMany(mappedBy = "rota")  
	private List<Stop> plannedStops;
	
	
	
	public Rota() {
			
	}
	
	
	public Rota(String assignedVehicle, List<Stop> plannedStops) {
		this.assignedVehicle = assignedVehicle;
		this.plannedStops = plannedStops;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssignedVehicle() {
		return assignedVehicle;
	}
	public void setAssignedVehicle(String assignedVehicle) {
		this.assignedVehicle = assignedVehicle;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public List<Stop> getPlannedStops() {
		return plannedStops;
	}
	public void setPlannedStops(List<Stop> plannedStops) {
		this.plannedStops = plannedStops;
	}
	
	
	
	
}
