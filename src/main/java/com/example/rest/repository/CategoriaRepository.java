package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

	
}
