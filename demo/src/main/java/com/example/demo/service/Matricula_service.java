package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exeptions.General_exeptions;
import com.example.demo.interfaces.Matricula_interface;
import com.example.demo.model.faculdade.Matricula_model;
import com.example.demo.repository.Matricula_repository;

@Service
public class Matricula_service implements Matricula_interface {

    @Autowired
    private Matricula_repository matricula_repository;

    public Matricula_service(Matricula_repository matricula_repository) {
        this.matricula_repository = matricula_repository;
    }

    @Override
    public List<Matricula_model> getAllMatriculas() {
        try {
            return matricula_repository.findAll();
        } catch (Exception e) {
            throw new General_exeptions("Matriculas não encontradas: ", e);
        }
    }

    @Override
    public Matricula_model getMatriculaById(Long id) {
        try {
            return matricula_repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new General_exeptions("Matricula não encontrada: ", e);
        }
    }

    @Override
    public Matricula_model saveMatricula(Matricula_model matricula) {
        try {
            return matricula_repository.save(matricula);
        } catch (Exception e) {
            throw new General_exeptions("Erro ao tentar cadastrar matricula: ", e);
        }
    }

    @Override
    public Matricula_model updateMatricula(Long id, Matricula_model newMatricula) {
        try {
            if (matricula_repository.existsById(id)) {
                Matricula_model matricula_model = matricula_repository.findById(id).get();
                matricula_model.setRegistromatricula(newMatricula.getRegistromatricula());
                matricula_model.setAluno(newMatricula.getAluno());
                matricula_model.setCurso(newMatricula.getCurso());
                matricula_model.setDatahoramatricula(newMatricula.getDatahoramatricula());
                return matricula_repository.save(matricula_model);
            
            } else {
                throw new General_exeptions("a matrícula não existe.");
            } 
        } catch (Exception e) {
            throw new General_exeptions("Não foi possível editar a matrícula", e);
        }
    }

    @Override
    public Matricula_model deletarMatricula(Long id) {
        if (matricula_repository.existsById(id)) {
            Matricula_model matricula_model = matricula_repository.findById(id).get();
            matricula_repository.delete(matricula_model);
            return matricula_model;
        } else {
            throw new General_exeptions("A matrícula não existe.");
        }
    }
    
}
