package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DadosGeralAluno_service;

@RestController
@RequestMapping("dados_geral_aluno")
public class DadosGeralAluno_controller {

    private DadosGeralAluno_service dadosGeralAluno_service;

    @Autowired
    public DadosGeralAluno_controller(DadosGeralAluno_service dadosGeralAluno_service){
        this.dadosGeralAluno_service = dadosGeralAluno_service;
    }

        @GetMapping("/alunos")
    public List<String> obterNomeCpfAluno(@RequestParam String nome, @RequestParam String cpf) {
        return dadosGeralAluno_service.obterNomeCpfAluno(nome, cpf);
    }

    /*@GetMapping("/cursos")
    public List<Object[]> obterNomeCursoPorRegistromatriculaEIdCurso(@RequestParam String registromatricula, @RequestParam int cursoId) {
        return dadosGeralAluno_service.obterNomeCursoPorRegistromatriculaEIdCurso(registromatricula, cursoId);
    }*/
    
}
