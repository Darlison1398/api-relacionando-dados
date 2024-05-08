package com.example.demo.model.faculdade;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "cursos")
public class Curso_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 100)
    private String turno;

    @Column
    private int cargahoraria;

    @ManyToOne
    @JoinColumn
    private Materia_model materia;

    public Curso_model (){}

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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public Materia_model getMateria() {
        return materia;
    }

    public void setMateria(Materia_model materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Curso_model [id=" + id + ", nome=" + nome + ", turno=" + turno + ", cargahoraria=" + cargahoraria
                + ", materia=" + materia + "]";
    }

    
    
    

    
}
