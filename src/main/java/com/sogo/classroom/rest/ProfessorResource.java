package com.sogo.classroom.rest;

import com.sogo.classroom.persistence.DTO.miniCurso.ProfessorMinicursoVinculoDTO;
import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.models.Professor;
import com.sogo.classroom.service.declaration.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Professor saveProfessor(@Valid @RequestBody ProfessorCadastroDTO professorCadastroDTO) {
        return this.professorService.saveProfessor(professorCadastroDTO);
    }

    @PostMapping("{id}/mini-cursos")
    public String vincularProfessorMinicurso(@PathVariable("id") Long id, @Valid @RequestBody ProfessorMinicursoVinculoDTO professorMinicursoVinculoDTO) {
        return this.professorService.vincularProfessorMinicurso(id, professorMinicursoVinculoDTO);
    }

}
