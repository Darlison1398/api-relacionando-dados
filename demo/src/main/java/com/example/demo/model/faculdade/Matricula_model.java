package com.example.demo.model.faculdade;

import java.sql.Date;
import org.hibernate.annotations.ManyToAny;
import com.example.demo.model.pessoas.Aluno_model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "matricula")
public class Matricula_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String registromatricula;

    @Column
    private Date datahoramatricula;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno_model aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso_model curso;

    public Matricula_model() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistromatricula() {
        return registromatricula;
    }

    public void setRegistromatricula(String registromatricula) {
        this.registromatricula = registromatricula;
    }

   

    public Aluno_model getAluno() {
        return aluno;
    }

    public void setAluno(Aluno_model aluno) {
        this.aluno = aluno;
    }

    public Curso_model getCurso() {
        return curso;
    }

    public void setCurso(Curso_model curso) {
        this.curso = curso;
    }

    public Date getDatahoramatricula() {
        return datahoramatricula;
    }

    public void setDatahoramatricula(Date datahoramatricula) {
        this.datahoramatricula = datahoramatricula;
    }

    @Override
    public String toString() {
        return "Matricula_model [id=" + id + ", registromatricula=" + registromatricula + ", datahoramatricula="
                + datahoramatricula + ", aluno=" + aluno + ", curso=" + curso + "]";
    }

    
    
}
