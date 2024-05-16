package com.example.demo.repository.imagem;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.imagens.Imagen_model;

public interface Imagem_repository extends JpaRepository<Imagen_model, Long> {
    
}
