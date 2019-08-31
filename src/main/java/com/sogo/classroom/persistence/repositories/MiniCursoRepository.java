package com.sogo.classroom.persistence.repositories;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoConsultaDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MiniCursoRepository extends JpaRepository<MiniCurso, Long> {

    @Query("SELECT new com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoConsultaDTO(mc.nome, mc.dataRealizacao, mc.duracaoPrevista, mc.totalVagas, mc.vagasPreenchidas) FROM MiniCurso mc WHERE mc.professor.id = :idProfessor")
    List<MiniCursoConsultaDTO> consultarMiniCursosMinistradosProfessor(Long idProfessor);
}
