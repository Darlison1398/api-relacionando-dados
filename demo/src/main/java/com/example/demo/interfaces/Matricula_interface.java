package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.faculdade.Matricula_model;

public interface Matricula_interface {
    List<Matricula_model> getAllMatriculas();
    Matricula_model getMatriculaById(Long id);
    Matricula_model saveMatricula(Matricula_model matricula);
    Matricula_model updateMatricula(Long id, Matricula_model newMatricula);
    Matricula_model deletarMatricula(Long id);
}
