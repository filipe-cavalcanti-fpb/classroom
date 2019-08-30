package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.ParticipanteMiniCursoInscricaoDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import com.sogo.classroom.service.declaration.ParticipanteService;
import com.sogo.classroom.service.mapper.MiniCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MiniCursoServiceImpl implements MiniCursoService {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @Autowired
    private ParticipanteService participanteService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO) {
        return this.miniCursoRepository.save(MiniCursoMapper.mapper(miniCursoCadastroDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MiniCurso inscreverAlunoMiniCurso(Long id, ParticipanteMiniCursoInscricaoDTO participanteMiniCursoInscricaoDTO) {
        Optional<MiniCurso> miniCurso = this.miniCursoRepository.findById(id);
        Optional<Participante> participante = this.participanteService.findById(id);
        return null;
    }
}
