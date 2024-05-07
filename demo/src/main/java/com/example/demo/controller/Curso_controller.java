package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.faculdade.Curso_model;
import com.example.demo.service.Curso_service;

@RestController
@RequestMapping("/curso")
public class Curso_controller {

    public Curso_service curso_service;

    @Autowired
    public Curso_controller(Curso_service curso_service){
        this.curso_service = curso_service;
    }

    @RequestMapping
    public List<Curso_model> obterCursos(){
        List<Curso_model> listaCursos = curso_service.getAllCurso();
        return listaCursos;
    }

    @RequestMapping("/cursoById/{id}")
    public Curso_model cursoPorId(@PathVariable Long id) {
        return curso_service.getCursoById(id);
    }
    
    @PostMapping("/criarCurso")
    public Curso_model criarCurso(@RequestBody Curso_model curso) {
        return curso_service.saveCurso(curso);
    }

    @PutMapping("/editarCurso/{ìd}")
    public Curso_model editarCurso(@PathVariable Long id, @RequestBody Curso_model curso){
        return curso_service.updateCurso(id, curso);
    }

    @DeleteMapping("/apagarCurso/{id}")
    public Curso_model excluirCurso(@PathVariable Long id) {
        return curso_service.deletarCurso(id);
    }
}
