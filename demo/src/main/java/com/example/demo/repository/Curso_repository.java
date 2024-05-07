package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.faculdade.Curso_model;

public interface Curso_repository extends JpaRepository <Curso_model, Long>{

}
