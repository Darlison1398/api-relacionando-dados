package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.Professor_interface;
import com.example.demo.model.pessoas.Professor_model;
import com.example.demo.repository.Professor_repository;

@Service
public class Professor_service implements Professor_interface {

    @Autowired
    private Professor_repository professor_repository;

    public Professor_service(Professor_repository professor_repository) {
        this.professor_repository = professor_repository;
    }

    @Override
    public List<Professor_model> getProfessores() {
        try{
            return professor_repository.findAll();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Professor_model getProfessorById(Long id) {
        try {
            return professor_repository.findById(id).orElse(null);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Professor_model saveProfessor(Professor_model professor) {
        try {
            return professor_repository.save(professor);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Professor_model updateProfessor(Long id, Professor_model newProfessor) {
        if (professor_repository.existsById(id)) {

            Professor_model professor_model = professor_repository.findById(id).get();
            professor_model.setNome(newProfessor.getNome());
            professor_model.setIdade(newProfessor.getIdade());
            professor_model.setCpf(newProfessor.getCpf());
            professor_model.setEmail(newProfessor.getEmail());
            professor_model.setRg(newProfessor.getRg());
            professor_model.setSexo(newProfessor.getSexo());
            professor_model.setRegistrofuncionario(newProfessor.getRegistrofuncionario());
            professor_model.setStatusfuncionario(newProfessor.isStatusfuncionario());

            return professor_repository.save(professor_model);

        } else {
            throw new RuntimeException("Erro ao tentar editar dados do professor.");
        }
    }

    @Override
    public Professor_model deletarProfessor(Long id) {

        if (professor_repository.existsById(id)) {
            Professor_model professor_model = professor_repository.findById(id).get();
            professor_repository.delete(professor_model);
            return professor_model;
            
        } else {
            throw new RuntimeException("Erro ao tentar deletar dados do professor.");
        }
    }
    
}
