package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.faculdade.Materia_model;

public interface Materia_repository extends JpaRepository<Materia_model, Long>{
    
}
