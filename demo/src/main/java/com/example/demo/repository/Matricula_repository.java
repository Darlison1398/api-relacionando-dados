package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.faculdade.Matricula_model;

public interface Matricula_repository extends JpaRepository<Matricula_model, Long> {
    
}
