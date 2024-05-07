package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exeptions.General_exeptions;
import com.example.demo.interfaces.Aluno_interface;
import com.example.demo.model.pessoas.Aluno_model;
import com.example.demo.repository.Aluno_repository;

@Service
public class Aluno_service implements Aluno_interface {

    @Autowired
    private Aluno_repository aluno_repository;

    public Aluno_service(Aluno_repository aluno_repository) {
        this.aluno_repository = aluno_repository;
    }

    @Override
    public List<Aluno_model> getAlunos() {
        try{
            return aluno_repository.findAll();
        } catch (Exception e){
            throw new General_exeptions("Alunos não encontrados", e);
        }
        
    }

    @Override
    public Aluno_model getAlunoById(Long id) {
        try {
            return aluno_repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new General_exeptions("Aluno não encontrados", e);
        }
    }

    @Override
    public Aluno_model saveAluno(Aluno_model aluno) {
        try {
            return aluno_repository.save(aluno);
        } catch (Exception e) {
            throw new General_exeptions("Erro ao tentar cadastrar aluno", e);
        }
        
    }

    @Override
    public Aluno_model updateAluno(Long id, Aluno_model newAluno) {
        if (aluno_repository.existsById(id)){

            Aluno_model aluno_model = aluno_repository.findById(id).get();

            aluno_model.setNome(newAluno.getNome());
            aluno_model.setCpf(newAluno.getCpf());
            aluno_model.setRg(newAluno.getRg());
            aluno_model.setEmail(newAluno.getEmail());
            aluno_model.setIdade(newAluno.getIdade());
            aluno_model.setSexo(newAluno.getSexo());
            aluno_model.setNumeromatricula(newAluno.getNumeromatricula());
            aluno_model.setStatusmatricula(newAluno.isStatusmatricula());
            aluno_model.setCurso(newAluno.getCurso());
            return aluno_repository.save(aluno_model);

        } else {
            throw new General_exeptions("Aluno não encontrado");
        }
    }

    @Override
    public Aluno_model deletarAluno(Long id) {
        if (aluno_repository.existsById(id)) {

            Aluno_model aluno_model = aluno_repository.findById(id).get();
            aluno_repository.delete(aluno_model);
            return aluno_model;

        } else {
            throw new General_exeptions("Não foi possível deletar o aluno.");
        }
    }
    
}
