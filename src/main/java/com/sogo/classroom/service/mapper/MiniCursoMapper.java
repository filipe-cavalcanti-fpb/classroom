package com.sogo.classroom.service.mapper;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Professor;

public class MiniCursoMapper {

    public static MiniCurso mapper(MiniCursoCadastroDTO miniCursoCadastroDTO, Professor professor) {
        MiniCurso miniCurso = new MiniCurso();
        miniCurso.setDataRealizacao(miniCursoCadastroDTO.getDataRealizacao());
        miniCurso.setDuracaoPrevista(miniCursoCadastroDTO.getDuracaoPrevista());
        miniCurso.setNome(miniCursoCadastroDTO.getNome());
        miniCurso.setTotalVagas(miniCursoCadastroDTO.getTotalVagas());
        miniCurso.setProfessor(professor);
        return miniCurso;
    }
}
