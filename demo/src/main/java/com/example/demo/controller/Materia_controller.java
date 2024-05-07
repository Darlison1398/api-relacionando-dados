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

import com.example.demo.model.faculdade.Materia_model;
import com.example.demo.service.Materia_service;

@RestController
@RequestMapping("materias")
public class Materia_controller {

    private Materia_service materia_service;

    @Autowired
    public Materia_controller(Materia_service materia_service){
        this.materia_service = materia_service;
    }
    
    @GetMapping
    public List<Materia_model> obterMaterias(){
        List<Materia_model> listaMaterias = materia_service.getAllMateria();
        return listaMaterias;
    }

    @GetMapping("/materiaById/{id}")
    public Materia_model materiaId(@PathVariable Long id){
        return materia_service.getMateriaById(id);
    }

    @PostMapping("/criarMateria")
    public Materia_model criarMateria(@RequestBody Materia_model materia){
        return materia_service.saveMateria(materia);
    }

    @PutMapping("/editarMateria/{id}")
    public Materia_model editarMateria(@PathVariable Long id, @RequestBody Materia_model materia){
        return materia_service.updateMateria(id, materia);
    }

    @DeleteMapping("/apagarMateria/{id}")
    public Materia_model apagarMateria(@PathVariable Long id){
        return materia_service.deletarMateria(id);
    }

}
