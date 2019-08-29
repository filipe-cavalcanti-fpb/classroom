package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.ParticipanteCadastroDTO;
import com.sogo.classroom.persistence.models.Participante;

public interface ParticipanteService {

    Participante saveParticipante(ParticipanteCadastroDTO participanteCadastroDTO);


}
