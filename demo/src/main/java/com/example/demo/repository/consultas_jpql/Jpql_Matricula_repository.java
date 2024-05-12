package com.example.demo.repository.consultas_jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.MatriculaDTO;
import com.example.demo.model.faculdade.Matricula_model;

@Repository
public interface Jpql_Matricula_repository extends JpaRepository<Matricula_model, Long> {

    @Query("SELECT new com.example.demo.model.dto.MatriculaDTO(m.registromatricula, a.nome, a.cpf) " +
        "FROM matricula m " +
        "INNER JOIN m.aluno a " +
        "WHERE m.id = :id")
    MatriculaDTO findByIdMatricula(Long id);

}