package com.example.demo.model.pessoas;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private int idade;

    @Column
    private String sexo;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String email;

    public Pessoa() {}

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



    public int getIdade() {
        return idade;
    }



    public void setIdade(int idade) {
        this.idade = idade;
    }



    public String getSexo() {
        return sexo;
    }



    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



    public String getRg() {
        return rg;
    }



    public void setRg(String rg) {
        this.rg = rg;
    }



    public String getCpf() {
        return cpf;
    }



    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", rg=" + rg + ", cpf="
                + cpf + ", email=" + email + "]";
    }

    
    

    

    
}
