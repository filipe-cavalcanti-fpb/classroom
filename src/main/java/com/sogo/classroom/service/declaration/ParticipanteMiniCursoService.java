package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.models.ParticipanteMiniCurso;

import java.util.List;

public interface ParticipanteMiniCursoService {

    ParticipanteMiniCurso inscreverParticipanteMiniCurso(MiniCurso miniCurso, Participante participante);

    List<MiniCurso> consultarMinicursosParticipante(Long idParticipante);

    public Boolean verificarInscricao(Participante participante);
}
