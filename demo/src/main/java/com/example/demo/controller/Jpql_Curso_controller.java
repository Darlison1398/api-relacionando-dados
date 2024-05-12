package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CursoDTO;
import com.example.demo.repository.consultas_jpql.Jpql_cursoMateria_repository;

@RestController
@RequestMapping("cursoMateria")
public class Jpql_Curso_controller {

    private Jpql_cursoMateria_repository materiaCurso_repository;

    @Autowired
    public Jpql_Curso_controller(Jpql_cursoMateria_repository materiaCurso_repository) {
        this.materiaCurso_repository = materiaCurso_repository;
    }

    @GetMapping("/{id}")
    public CursoDTO findMateriaCursoById(@PathVariable Long id) {
        return materiaCurso_repository.findCursoMateriaById(id);
    }
    
}
