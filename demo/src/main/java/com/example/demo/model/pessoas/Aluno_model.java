package com.example.demo.model.pessoas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "aluno")
public class Aluno_model extends Pessoa{

    @Column
    private int numeromatricula;

    @Column(length = 9)
    private boolean statusmatricula;

    @Column(length = 150)
    private String curso;

    

    public Aluno_model() {}

    public int getNumeromatricula() {
        return numeromatricula;
    }

    public void setNumeromatricula(int numeromatricula) {
        this.numeromatricula = numeromatricula;
    }

    public boolean isStatusmatricula() {
        return statusmatricula;
    }

    public void setStatusmatricula(boolean statusmatricula) {
        this.statusmatricula = statusmatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno_model [numeromatricula=" + numeromatricula + ", statusmatricula=" + statusmatricula + ", curso="
                + curso + "]";
    }

    
    
}
