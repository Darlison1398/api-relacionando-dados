package com.example.demo.model.pessoas;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity (name = "professor")
public class Professor_model extends Pessoa {

    @Column
    private int registrofuncionario;

    @Column (length = 8)
    private boolean statusfuncionario;


    public Professor_model() {}

    public int getRegistrofuncionario() {
        return registrofuncionario;
    }

    public void setRegistrofuncionario(int registrofuncionario) {
        this.registrofuncionario = registrofuncionario;
    }

    public boolean isStatusfuncionario() {
        return statusfuncionario;
    }

    public void setStatusfuncionario(boolean statusfuncionario) {
        this.statusfuncionario = statusfuncionario;
    }
    


    
}
