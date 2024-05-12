package com.example.demo.model.dto;

public class MatriculaDTO {

    private String registroMatricula;
    private String nomeAluno;
    private String cpfAluno;

    public MatriculaDTO() {}

    

    public MatriculaDTO(String registroMatricula, String nomeAluno, String cpfAluno) {
        this.registroMatricula = registroMatricula;
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
    }



    public String getRegistroMatricula() {
        return registroMatricula;
    }

    public void setRegistroMatricula(String registroMatricula) {
        this.registroMatricula = registroMatricula;
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

    
    
}
