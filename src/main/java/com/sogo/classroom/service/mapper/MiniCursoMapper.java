package com.sogo.classroom.service.mapper;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.models.MiniCurso;

public class MiniCursoMapper {

    public static MiniCurso mapper(MiniCursoCadastroDTO miniCursoCadastroDTO) {
        MiniCurso miniCurso = new MiniCurso();
        miniCurso.setDataRealizacao(miniCursoCadastroDTO.getDataRealizacao());
        miniCurso.setDuracaoPrevista(miniCursoCadastroDTO.getDuracaoPrevista());
        miniCurso.setNome(miniCursoCadastroDTO.getNome());
        miniCurso.setTotalVagas(miniCursoCadastroDTO.getTotalVagas());
        return miniCurso;
    }
}
