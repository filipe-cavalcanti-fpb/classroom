package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.participante.ParticipanteCadastroDTO;
import com.sogo.classroom.persistence.models.Participante;

import java.util.Optional;

public interface ParticipanteService {

    Participante saveParticipante(ParticipanteCadastroDTO participanteCadastroDTO);

    Participante findById(Long id);


}
