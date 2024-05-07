package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.faculdade.Matricula_model;
import com.example.demo.service.Matricula_service;

@RestController
@RequestMapping("matricula")
public class Matricula_controller {

    public Matricula_service matricula_service;

    @Autowired
    public Matricula_controller(Matricula_service matricula_service) {
        this.matricula_service = matricula_service;
    }

    @GetMapping
    public List<Matricula_model> obterMatriculas() {
        List<Matricula_model> listaMatriculas = matricula_service.getAllMatriculas();
        return listaMatriculas;
    }
    
    @GetMapping("matriculaById/{id}")
    public Matricula_model matriculaById(@PathVariable Long id) {
        return matricula_service.getMatriculaById(id);
    }

    @PostMapping("criarMatricula")
    public Matricula_model criarMatricula(@RequestBody Matricula_model matricula) {
        return matricula_service.saveMatricula(matricula);
    }

    @PutMapping("/editarMatricula/{id}")
    public Matricula_model editarMatricula(@PathVariable Long id, @RequestBody Matricula_model matriculaNova) {
        return matricula_service.updateMatricula(id, matriculaNova);
    }

    @DeleteMapping("apagarMatricula/{id}")
    public Matricula_model apagarMatricula(@PathVariable Long id) {
        return matricula_service.deletarMatricula(id);
    }

}
