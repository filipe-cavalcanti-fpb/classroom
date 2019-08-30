package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.models.ParticipanteMiniCurso;

public interface ParticipanteMiniCursoService {

    ParticipanteMiniCurso inscreverParticipanteMiniCurso(MiniCurso miniCurso, Participante participante);
}
