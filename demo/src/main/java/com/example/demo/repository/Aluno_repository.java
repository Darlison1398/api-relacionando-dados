package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.pessoas.Aluno_model;


public interface Aluno_repository extends JpaRepository<Aluno_model, Long> {
    
}
