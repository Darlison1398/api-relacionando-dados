package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.pessoas.Aluno_model;

public interface Aluno_interface {
    List<Aluno_model> getAlunos();
    Aluno_model getAlunoById(Long id);
    Aluno_model saveAluno(Aluno_model aluno);
    Aluno_model updateAluno(Long id, Aluno_model newAluno);
    Aluno_model deletarAluno(Long id);
}
