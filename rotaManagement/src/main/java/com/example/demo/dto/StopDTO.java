package com.example.demo.dto;

import com.example.demo.domain.Rota;
import com.example.demo.domain.Stop;


// UTILIZAR CASO DÊ TEMPO DE TERMINAR
public class StopDTO {

	private double lat;
	private double lng;
	private String description;
	private int deliveryRadius;
	private Rota rota;
	
	
	
	
	public Stop stopTransformer(Stop stop) {
		return new Stop(stop.getLat(), stop.getLng(), stop.getDescription(), stop.getDeliveryRadius(), stop.getRota());
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDeliveryRadius() {
		return deliveryRadius;
	}
	public void setDeliveryRadius(int deliveryRadius) {
		this.deliveryRadius = deliveryRadius;
	}
	public Rota getRota() {
		return rota;
	}
	public void setRota(Rota rota) {
		this.rota = rota;
	}
	
	
	
}
