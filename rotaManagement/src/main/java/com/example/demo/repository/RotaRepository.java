package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Rota;

public interface RotaRepository extends JpaRepository<Rota,Long>{
	Optional<Rota> findById(Long Id);
}
