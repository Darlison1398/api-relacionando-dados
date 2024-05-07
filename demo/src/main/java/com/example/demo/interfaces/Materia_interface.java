package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.faculdade.Materia_model;

public interface Materia_interface {
    List<Materia_model> getAllMateria();
    Materia_model getMateriaById(Long id);
    Materia_model saveMateria(Materia_model materia);
    Materia_model updateMateria(Long id, Materia_model newMateria);
    Materia_model deletarMateria(Long id);
    
}
