package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.participante.ParticipanteCadastroDTO;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.repositories.ParticipanteRepository;
import com.sogo.classroom.service.declaration.ParticipanteService;
import com.sogo.classroom.service.mapper.ParticipanteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Participante saveParticipante(ParticipanteCadastroDTO participanteCadastroDTO) {
        return this.participanteRepository.save(ParticipanteMapper.mapper(participanteCadastroDTO));
    }
}
