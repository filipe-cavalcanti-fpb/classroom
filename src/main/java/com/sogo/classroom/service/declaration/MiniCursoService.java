package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.models.MiniCurso;

public interface MiniCursoService {

    MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO);
}
