package com.sogo.classroom.rest;

import com.sogo.classroom.persistence.DTO.ParticipanteCadastroDTO;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.service.declaration.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "participantes")
public class ParticipanteResource {

    @Autowired
    private ParticipanteService participanteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Participante saveParticipante(@RequestBody ParticipanteCadastroDTO participanteCadastroDTO) {
        return this.participanteService.saveParticipante(participanteCadastroDTO);
    }
}
