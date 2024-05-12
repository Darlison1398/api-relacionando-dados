package com.example.demo.repository.consultas_jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.dto.CursoDTO;
import com.example.demo.model.faculdade.Curso_model;

public interface Jpql_cursoMateria_repository extends JpaRepository<Curso_model, Long>{

    @Query("SELECT new com.example.demo.model.dto.CursoDTO(c.nome AS nome_curso, m.nome AS nome_materia, m.descricao) " +
            "FROM cursos c " +
            "INNER JOIN c.materia m " +
            "WHERE c.id = :id"
    )
    CursoDTO findCursoMateriaById(Long id);
    
}
