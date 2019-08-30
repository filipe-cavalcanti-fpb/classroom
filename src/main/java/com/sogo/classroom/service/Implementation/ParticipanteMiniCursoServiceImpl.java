package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.models.ParticipanteMiniCurso;
import com.sogo.classroom.persistence.repositories.ParticipanteMiniCursoRepository;
import com.sogo.classroom.service.declaration.ParticipanteMiniCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ParticipanteMiniCursoServiceImpl implements ParticipanteMiniCursoService {

    @Autowired
    private ParticipanteMiniCursoRepository participanteMiniCursoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ParticipanteMiniCurso inscreverParticipanteMiniCurso(MiniCurso miniCurso, Participante participante) {
        ParticipanteMiniCurso participanteMiniCurso = new ParticipanteMiniCurso();
        participanteMiniCurso.setDataInscricao(LocalDateTime.now());
        participanteMiniCurso.setMiniCurso(miniCurso);
        participanteMiniCurso.setParticipante(participante);
        return this.participanteMiniCursoRepository.save(participanteMiniCurso);
    }
}
