package com.sogo.classroom.service.mapper;

import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.models.Professor;
import com.sogo.classroom.persistence.models.Telefone;

import java.util.stream.Collectors;

public class ProfessorMapper {

    public static Professor mapper(ProfessorCadastroDTO professorCadastroDTO) {
        Professor professor = new Professor();
        professor.setMatricula(professorCadastroDTO.getMatricula());
        professor.setTelefones(professorCadastroDTO.getTelefones().stream().map(Telefone::new).collect(Collectors.toSet()));
        professor.setEmail(professorCadastroDTO.getEmail());
        professor.setNome(professorCadastroDTO.getNome());
        professor.setSenha(professorCadastroDTO.getSenha());
        return professor;
    }
}
