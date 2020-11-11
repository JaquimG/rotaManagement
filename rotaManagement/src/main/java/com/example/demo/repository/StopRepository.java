package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {
	
}
