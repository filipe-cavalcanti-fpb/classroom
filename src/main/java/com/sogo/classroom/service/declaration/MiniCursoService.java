package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.ParticipanteMiniCursoInscricaoDTO;
import com.sogo.classroom.persistence.models.MiniCurso;

public interface MiniCursoService {

    MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO);

    String inscreverAlunoMiniCurso(Long id, ParticipanteMiniCursoInscricaoDTO participanteMiniCursoInscricaoDTO);

    MiniCurso findById(Long id);

    public void atualizar(MiniCurso miniCurso);

}
