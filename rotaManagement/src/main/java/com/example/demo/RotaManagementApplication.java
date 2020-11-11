package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.controller.RotaController;
import com.example.demo.service.RotaService;

@SpringBootApplication

public class RotaManagementApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(RotaManagementApplication.class, args);
	}

}
