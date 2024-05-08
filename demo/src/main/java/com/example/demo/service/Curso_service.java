package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exeptions.General_exeptions;
import com.example.demo.interfaces.Curso_interface;
import com.example.demo.model.faculdade.Curso_model;
import com.example.demo.model.faculdade.Materia_model;
import com.example.demo.repository.Curso_repository;

@Service
public class Curso_service implements Curso_interface {

    @Autowired
    private Curso_repository curso_repository;
    
    public Curso_service(Curso_repository curso_repository) {
        this.curso_repository = curso_repository;
    }

    @Override
    public List<Curso_model> getAllCurso() {
        try {
            return curso_repository.findAll();
        } catch (Exception e) {
            throw new General_exeptions("Cursos não encontrado!",e);
        }
        
    }

    @Override
    public Curso_model getCursoById(Long id) {
        try {
            return curso_repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new General_exeptions("Curso não encontrado!", e);
        }
    }

    @Override
    public Curso_model saveCurso(Curso_model curso) {
        try {
            Materia_model materia = curso.getMateria();
            curso.setMateria(materia);
            return curso_repository.save(curso);
        } catch (Exception e) {
            throw new General_exeptions("Erro ao tentar salvar curso.", e);
        }
    }

    @Override
    public Curso_model updateCurso(Long id, Curso_model newCurso) {

        if (curso_repository.existsById(id)) {
            Curso_model curso_model = curso_repository.findById(id).get();
            curso_model.setNome(newCurso.getNome());
            curso_model.setTurno(newCurso.getTurno());
            curso_model.setCargahoraria(newCurso.getCargahoraria());
            curso_model.setMateria(newCurso.getMateria());
            return curso_repository.save(curso_model);

        } else{
            throw new General_exeptions("Curso não encontrado!");
        }
    }

    @Override
    public Curso_model deletarCurso(Long id) {
        if (curso_repository.existsById(id)) {
            Curso_model curso_model = curso_repository.findById(id).get();
            curso_repository.delete(curso_model);
            return curso_model;
        } else {
            throw new General_exeptions("Erro ao tentar deletar dados do curso.");
        }
    }

}
