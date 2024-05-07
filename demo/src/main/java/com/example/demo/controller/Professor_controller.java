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

import com.example.demo.model.pessoas.Professor_model;
import com.example.demo.service.Professor_service;

@RestController
@RequestMapping("/professor")
public class Professor_controller {

    private Professor_service professor_service;

    @Autowired
    public Professor_controller(Professor_service professor_service) {
        this.professor_service = professor_service;
    }

    @GetMapping
    public List<Professor_model> getAllProfessores() {
        List<Professor_model> professores = professor_service.getProfessores();
        return professores;
    }
    
    @GetMapping("/professorById/{id}")
    public Professor_model getProById(@PathVariable Long id){
        return professor_service.getProfessorById(id);
    }

    @PostMapping("/salvarProfessor")
    public Professor_model salvarProfessor(@RequestBody Professor_model professor) {
        return professor_service.saveProfessor(professor);
    }

    @PutMapping("/editarProfessor/{id}")
    public Professor_model editarProfessor(@PathVariable Long id, @RequestBody Professor_model professor) {
        return professor_service.updateProfessor(id, professor);
    }

    @DeleteMapping("/deletarProfessor/{id}")
    public Professor_model deletarProfessor(@PathVariable Long id) {
        return professor_service.deletarProfessor(id);
    }


}
