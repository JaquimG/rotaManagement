package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Stop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double lat;
	private double lng;
	private String description;
	private int deliveryRadius;

	@ManyToOne
	@JoinColumn(name = "ROTA_ID")    // Criei esse atributo como chave estrangeira pra linkar as duas entities
	private Rota rota;
	
	public Stop() {
		
	}
	
	public Stop(double lat, double lng, String description, int deliveryRadius, Rota rota) {
		this.lat = lat;
		this.lng = lng;
		this.description = description;
		this.deliveryRadius = deliveryRadius;
		this.rota = rota;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
