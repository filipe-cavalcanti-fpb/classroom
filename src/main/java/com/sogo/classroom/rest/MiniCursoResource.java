package com.sogo.classroom.rest;

import com.sogo.classroom.persistence.DTO.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/mini-cursos")
public class MiniCursoResource {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @Autowired
    private MiniCursoService miniCursoService;

    @GetMapping
    public List<MiniCurso> findAll(){
        return this.miniCursoRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MiniCurso saveMiniCurso(@RequestBody MiniCursoCadastroDTO miniCursoCadastroDTO){
        return this.miniCursoService.saveMiniCurso(miniCursoCadastroDTO);
    }

}