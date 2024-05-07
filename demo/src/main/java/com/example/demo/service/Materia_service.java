package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exeptions.General_exeptions;
import com.example.demo.interfaces.Materia_interface;
import com.example.demo.model.faculdade.Materia_model;
import com.example.demo.repository.Materia_repository;

@Service
public class Materia_service implements Materia_interface {

    @Autowired
    private Materia_repository materia_repository;

    public Materia_service(Materia_repository materia_repository) {
        this.materia_repository = materia_repository;
    }

    @Override
    public List<Materia_model> getAllMateria() {
        try {
            return materia_repository.findAll();
        } catch (Exception e) {
            throw new General_exeptions("Matérias não encontradas.", e);
        }
    }

    @Override
    public Materia_model getMateriaById(Long id) {
        try {
            return materia_repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new General_exeptions("Matéria não encontrada.", e);
        }
    }

    @Override
    public Materia_model saveMateria(Materia_model materia) {
        try {
            return materia_repository.save(materia);
        } catch (Exception e) {
            throw new General_exeptions("Erro ao tentar cadastrar matéria.", e);
        }
    }

    @Override
    public Materia_model updateMateria(Long id, Materia_model newMateria) {
        if (materia_repository.existsById(id)) {
            Materia_model materia_model = materia_repository.findById(id).get();
            materia_model.setNome(newMateria.getNome());
            materia_model.setDescricao(newMateria.getDescricao());
            materia_model.setCargahoraria(newMateria.getCargahoraria());
            return materia_repository.save(materia_model);
        } else {
            throw new RuntimeException("Erro ao tentar editar dados da matéria.");
        }
    }

    @Override
    public Materia_model deletarMateria(Long id) {
        if (materia_repository.existsById(id)) {
            Materia_model materia_model = materia_repository.findById(id).get();
            materia_repository.delete(materia_model);
            return materia_model;
        } else {
            throw new RuntimeException("Erro ao tentar deletar dados da matéria.");
        }
    }
    
}
