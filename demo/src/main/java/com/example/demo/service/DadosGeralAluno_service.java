package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DadosGeralAluno_repository;

@Service
public class DadosGeralAluno_service {

    @Autowired
    private DadosGeralAluno_repository dadosGeralAluno_repository;

    public List<String> obterNomeCpfAluno(String nome, String cpf) {
        List<Object[]> resultados = dadosGeralAluno_repository.obterNomeCpfAluno(nome, cpf);
        List<String> nomeCpfAlunos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            nomeCpfAlunos.add(resultado[0] + " - " + resultado[1]);
        }
        return nomeCpfAlunos;
    }

    /*public List<Object[]> obterNomeCursoPorRegistromatriculaEIdCurso(String registromatricula, int cursoId) {
        return dadosGeralAluno_repository.obterRmatriculaCursoAluno(registromatricula, cursoId);
    }*/
    

    public DadosGeralAluno_service(DadosGeralAluno_repository dadosGeralAluno_repository){
        this.dadosGeralAluno_repository = dadosGeralAluno_repository;
    }
    
}
