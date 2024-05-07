package com.example.demo.model.faculdade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "materias")
public class Materia_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column
    private int cargahoraria;
    

    public Materia_model() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getCargahoraria() {
        return cargahoraria;
    }


    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }


    @Override
    public String toString() {
        return "Materia_model [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", cargahoraria="
                + cargahoraria + "]";
    }

    
    
}
