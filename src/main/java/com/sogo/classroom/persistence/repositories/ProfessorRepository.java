package com.sogo.classroom.persistence.repositories;

import com.sogo.classroom.persistence.DTO.professor.ProfessorConsultaDTO;
import com.sogo.classroom.persistence.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT NEW com.sogo.classroom.persistence.DTO.professor.ProfessorConsultaDTO(prof.id, prof.nome) FROM Professor prof")
    List<ProfessorConsultaDTO> consultarProfessores();

}
