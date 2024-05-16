package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.imagens.Imagen_model;
import com.example.demo.repository.imagem.Imagem_repository;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("imagem")
public class Imagem_controller {
    
    @Value("${file.upload-dir}")
    private String uploadDir;

    private Imagem_repository imagem_repository;

    @Autowired
    public Imagem_controller(Imagem_repository imagem_repository) {
        this.imagem_repository = imagem_repository;
    }

    @PostMapping("/upload")
    public Imagen_model uploadImagem(@RequestParam("image") MultipartFile file) throws IOException {
        
        if (file.isEmpty()) {
            throw new RuntimeException("Please select a file to upload.");
        }

        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Salva o arquivo no sistema de arquivos
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir, filename);
        Files.write(path, file.getBytes());

        // Salva os detalhes da imagem no banco de dados
        Imagen_model image = new Imagen_model();
        image.setFilename(filename);
        image.setPath(path.toString());
        return imagem_repository.save(image);

    } 




}
