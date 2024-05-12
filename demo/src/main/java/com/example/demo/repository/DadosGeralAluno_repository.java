package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.pessoas.Aluno_model;

public interface DadosGeralAluno_repository extends JpaRepository<Aluno_model, Long> {

    @Query("SELECT a.nome, a.cpf FROM aluno a")
    List <Object[]> obterNomeCpfAluno(String nome, String cpf);

    /*@Query("SELECT m.registromatricula, m.curso FROM Matricula m WHERE m.registromatricula = ?1 AND m.curso = ?2")
    List <Object[]> obterRmatriculaCursoAluno(String registromatricula, int curso);*/

    
}
