package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.pessoas.Professor_model;

public interface Professor_interface {
    List<Professor_model> getProfessores();
    Professor_model getProfessorById(Long id);
    Professor_model saveProfessor(Professor_model professor);
    Professor_model updateProfessor(Long id, Professor_model newProfessor);
    Professor_model deletarProfessor(Long id);
}
