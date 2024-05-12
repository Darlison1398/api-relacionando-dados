package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.Historico_alunoDTO;
import com.example.demo.repository.consultas_jpql.Jpql_historicoAluno_repository;

@RestController
@RequestMapping("historicoAluno")
public class Jpql_HistoricoAluno_controller {

    private Jpql_historicoAluno_repository jpql_historicoAluno_repository;

    @Autowired
    public Jpql_HistoricoAluno_controller(Jpql_historicoAluno_repository jpql_historicoAluno_repository) {
        this.jpql_historicoAluno_repository = jpql_historicoAluno_repository;
    }

    @GetMapping("/{id}")
    public Historico_alunoDTO findByIdMatricula(@PathVariable Long id) {
        return jpql_historicoAluno_repository.findHistoricoAlunoByIdMatricula(id);
    }
    
}
