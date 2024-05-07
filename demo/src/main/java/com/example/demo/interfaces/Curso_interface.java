package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.faculdade.Curso_model;

public interface Curso_interface {
    List<Curso_model> getAllCurso();
    Curso_model getCursoById(Long id);
    Curso_model saveCurso(Curso_model curso);
    Curso_model updateCurso(Long id, Curso_model newCurso);
    Curso_model deletarCurso(Long id);
}
