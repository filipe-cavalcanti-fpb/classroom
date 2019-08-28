package com.sogo.classroom;

import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mini-cursos")
public class MiniCursoResource {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @GetMapping
    List<MiniCurso> findAll(){
        return this.miniCursoRepository.findAll();
    }
}
