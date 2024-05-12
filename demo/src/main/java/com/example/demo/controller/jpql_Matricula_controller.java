package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.MatriculaDTO;
import com.example.demo.repository.consultas_jpql.Jpql_Matricula_repository;

@RestController
@RequestMapping("matriculaAluno")
public class jpql_Matricula_controller {


    private Jpql_Matricula_repository matriculaRepository;

    @Autowired
    public jpql_Matricula_controller(Jpql_Matricula_repository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @GetMapping("/{id}")
    public MatriculaDTO findById(@PathVariable Long id) {
        return matriculaRepository.findByIdMatricula(id);
    }
}
