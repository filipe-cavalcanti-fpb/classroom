package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoConsultaDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.ParticipanteMiniCursoInscricaoDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import com.sogo.classroom.service.declaration.ParticipanteMiniCursoService;
import com.sogo.classroom.service.declaration.ParticipanteService;
import com.sogo.classroom.service.mapper.MiniCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MiniCursoServiceImpl implements MiniCursoService {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private ParticipanteMiniCursoService participanteMiniCursoService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO) {
        return this.miniCursoRepository.save(MiniCursoMapper.mapper(miniCursoCadastroDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String inscreverParticipanteMiniCurso(Long id, ParticipanteMiniCursoInscricaoDTO participanteMiniCursoInscricaoDTO) {
        MiniCurso miniCurso = this.miniCursoRepository.findById(id).orElseThrow(NoSuchElementException::new);

        Participante participante = this.participanteService.findById(participanteMiniCursoInscricaoDTO.getIdParticipante()).orElseThrow(NoSuchElementException::new);
        if(this.participanteMiniCursoService.verificarInscricao(participante)){
            //TODO: filipe.cavalcanti - alterar esse trecho
            return "participante já incluso";
        }
        miniCurso.setVagasPreenchidas(miniCurso.getVagasPreenchidas()+1);
        this.participanteMiniCursoService.inscreverParticipanteMiniCurso(miniCurso, participante);
        return "Inclusão realizada com sucesso";
    }

    @Override
    public MiniCurso findById(Long id) {
        return this.miniCursoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void atualizar(MiniCurso miniCurso) {
        this.miniCursoRepository.save(miniCurso);
    }

    @Override
    public List<MiniCursoConsultaDTO> consultarMiniCursosMinistradosProfessor(Long idProfessor) {
        return this.miniCursoRepository.consultarMiniCursosMinistradosProfessor(idProfessor);
    }
}
