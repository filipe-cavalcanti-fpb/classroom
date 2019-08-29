package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.ParticipanteCadastroDTO;
import com.sogo.classroom.persistence.models.Participante;
import org.springframework.stereotype.Service;

@Service
public interface ParticipanteService {

    Participante cadastrarParticipante(ParticipanteCadastroDTO participanteCadastroDTO);


}
