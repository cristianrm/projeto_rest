package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
