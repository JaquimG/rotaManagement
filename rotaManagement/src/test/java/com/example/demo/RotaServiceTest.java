package com.example.demo;


import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Rota;
import com.example.demo.service.RotaService; 

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RotaServiceTest {
	
	@Autowired
	RotaService rotaService;
	
	
	@Test
	public void rotaTestCreate(Rota rota) { 
		Rota rotaCreated = rotaService.create(rota);
		assertNotNull(rotaCreated);
		
	}
	
	@Test
	public void updateTest(Rota rota) {
		Rota rotaCreated = rotaService.update(rota);
		assertNotNull(rotaCreated);
	}
	
	//TODO continuar testes unitários
	
	
	
	

}
