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

import com.example.demo.model.pessoas.Aluno_model;
import com.example.demo.service.Aluno_service;

@RestController
@RequestMapping("/aluno")
public class Aluno_controller {

    private Aluno_service aluno_service;

    @Autowired
    public Aluno_controller(Aluno_service aluno_service) {
        this.aluno_service = aluno_service;
    }

    @GetMapping
    public List<Aluno_model> getAllAlunos() {
        List<Aluno_model> allAlunos = aluno_service.getAlunos();
        return allAlunos;
    }

    @GetMapping("/alunoById/{id}")
    public Aluno_model getAlunoById(@PathVariable Long id) {
        return aluno_service.getAlunoById(id);   
    }

    @PostMapping("/salvarAluno")
    public Aluno_model saveAluno(@RequestBody Aluno_model aluno) {
        return aluno_service.saveAluno(aluno);
    }

    @PutMapping("/editarAluno/{id}")
    public Aluno_model editarAluno(@PathVariable Long id, @RequestBody Aluno_model aluno) {
        return aluno_service.updateAluno(id, aluno);
    }

    @DeleteMapping("/deletarAluno/{id}")
    public Aluno_model deletarAluno_model(@PathVariable Long id) {
        return aluno_service.deletarAluno(id);
    }
    
}
