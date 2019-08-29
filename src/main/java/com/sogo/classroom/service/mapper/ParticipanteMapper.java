package com.sogo.classroom.service.mapper;

import com.sogo.classroom.persistence.DTO.ParticipanteCadastroDTO;
import com.sogo.classroom.persistence.models.Participante;

public class ParticipanteMapper {

    public static Participante mapper(ParticipanteCadastroDTO participanteCadastroDTO) {
        Participante participante = new Participante();
        participante.setCpf(participanteCadastroDTO.getCpf());
        participante.setDataNascimento(participanteCadastroDTO.getDataNascimento());
        participante.setEmail(participanteCadastroDTO.getEmail());
        participante.setNome(participanteCadastroDTO.getNome());
        participante.setSenha(participanteCadastroDTO.getSenha());
        return participante;
    }
}
