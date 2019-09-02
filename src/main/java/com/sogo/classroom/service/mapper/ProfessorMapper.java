package com.sogo.classroom.service.mapper;

import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.models.Professor;
import com.sogo.classroom.persistence.models.Telefone;

import java.util.ArrayList;
import java.util.List;

public class ProfessorMapper {

    public static Professor mapper(ProfessorCadastroDTO professorCadastroDTO) {
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(new Telefone(professorCadastroDTO.getTelefones()));
        Professor professor = new Professor();
        professor.setMatricula(professorCadastroDTO.getMatricula());
        professor.setTelefones(telefones);
        professor.setEmail(professorCadastroDTO.getEmail());
        professor.setNome(professorCadastroDTO.getNome());
        professor.setSenha(professorCadastroDTO.getSenha());
        return professor;
    }
}
