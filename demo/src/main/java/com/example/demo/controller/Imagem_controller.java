package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    @PutMapping("/editarImagem")
    public Imagen_model editarImagem (@RequestParam("id") Long id, @RequestParam("image") MultipartFile newFile) throws IOException {

        Imagen_model existImage = imagem_repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Image not found"));

        if (newFile.isEmpty()) {
            throw new RuntimeException("Por favor, selecione uma imagem para editar.");
        }

        // Apaga o arquivo antigo do sistema de arquivos, se necessário
        Path oldFilePath = Paths.get(existImage.getPath());
        Files.deleteIfExists(oldFilePath);

        // Salva o novo arquivo no sistema de arquivos
        String newFilename = System.currentTimeMillis() + "_" + newFile.getOriginalFilename();
        Path newPath = Paths.get(uploadDir, newFilename);
        Files.write(newPath, newFile.getBytes());

        // Atualiza os detalhes da imagem no banco de dados
        existImage.setFilename(newFilename);
        existImage.setPath(newPath.toString());

        return imagem_repository.save(existImage);

    }

    @GetMapping("/listaImagens")
    public List<Imagen_model> todasImagens() {
        List<Imagen_model> imagens = imagem_repository.findAll();

        // Construir a URL completa para cada imagem
        imagens.forEach(imagem -> {
            String filename = imagem.getFilename();
            String imageUrl = "http://localhost:8282/files/" + filename; // Ajuste a porta conforme a sua configuração
    
            // Setar a URL completa da imagem
            imagem.setUrl(imageUrl);
        });
    
        return imagens;
    }

    @DeleteMapping("/apagarImagem/{id}")
    public ResponseEntity<String> apagarImg(@PathVariable Long id) {
        Imagen_model existImage = imagem_repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Image not found"));

        // Apagar o arquivo do sistema de arquivos
        Path filePath = Paths.get(existImage.getPath());
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao apagar o arquivo", e);
        }

        // Apagar o registro do banco de dados
        imagem_repository.deleteById(id);

        return ResponseEntity.ok("Imagem apagada com sucesso");
    }





}
