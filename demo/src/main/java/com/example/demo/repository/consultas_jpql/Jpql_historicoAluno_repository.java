package com.example.demo.repository.consultas_jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.Historico_alunoDTO;
import com.example.demo.model.faculdade.Matricula_model;

@Repository
public interface Jpql_historicoAluno_repository extends JpaRepository<Matricula_model, Long> {

    @Query("SELECT new com.example.demo.model.dto.Historico_alunoDTO(m.registromatricula, a.nome AS nome_aluno, a.cpf, c.nome AS nome_curso, c.cargahoraria) " +
            "FROM matricula m " +
            "INNER JOIN m.aluno a " +
            "INNER JOIN m.curso c " +
            "WHERE m.id = :id"
    )
    Historico_alunoDTO findHistoricoAlunoByIdMatricula(Long id);
    
}
