package com.example.demo.model.dto;

public class CursoDTO {

    private String nomeCurso;
    private String nomeMateria;
    private String descricaoMateria;

    public CursoDTO(String nomeCurso, String nomeMateria, String descricaoMateria) {
        this.nomeCurso = nomeCurso;
        this.nomeMateria = nomeMateria;
        this.descricaoMateria = descricaoMateria;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getDescricaoMateria() {
        return descricaoMateria;
    }

    public void setDescricaoMateria(String descricaoMateria) {
        this.descricaoMateria = descricaoMateria;
    }

    

    

    
}
