package com.example.demo.model.dto;

public class Historico_alunoDTO {

    private String nomeAluno;
    private String cpfAluno;
    private String registroMarticulaAluno;
    private String nomeCurso;
    private int cargaHorariaCurso;


    
    public Historico_alunoDTO() {
    }


    public Historico_alunoDTO(String nomeAluno, String cpfAluno, String registroMarticulaAluno, String nomeCurso, int cargaHorariaCurso) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.registroMarticulaAluno = registroMarticulaAluno;
        this.nomeCurso = nomeCurso;
        this.cargaHorariaCurso = cargaHorariaCurso;
    }


    public String getNomeAluno() {
        return nomeAluno;
    }


    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }


    public String getCpfAluno() {
        return cpfAluno;
    }


    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }


    public String getRegistroMarticulaAluno() {
        return registroMarticulaAluno;
    }


    public void setRegistroMarticulaAluno(String registroMarticulaAluno) {
        this.registroMarticulaAluno = registroMarticulaAluno;
    }


    public String getNomeCurso() {
        return nomeCurso;
    }


    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }


    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }


    public void setCargaHorariaCurso(int cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    

    
    
    
}
