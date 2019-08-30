package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.models.Professor;

public interface ProfessorService {

    Professor saveProfessor(ProfessorCadastroDTO professorCadastroDTO);
}
