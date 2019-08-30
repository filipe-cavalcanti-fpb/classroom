package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.miniCurso.ProfessorMinicursoVinculoDTO;
import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.models.Professor;

public interface ProfessorService {

    Professor saveProfessor(ProfessorCadastroDTO professorCadastroDTO);

    String vincularProfessorMinicurso(Long idProfessor , ProfessorMinicursoVinculoDTO professorMinicursoVinculoDTO);

    Professor findById(Long id);
}
