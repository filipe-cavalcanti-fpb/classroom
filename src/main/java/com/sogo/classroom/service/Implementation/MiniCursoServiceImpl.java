package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoConsultaDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.ParticipanteMiniCursoInscricaoDTO;
import com.sogo.classroom.persistence.DTO.response.MensagemRetornoDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.models.Professor;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import com.sogo.classroom.persistence.repositories.ProfessorRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import com.sogo.classroom.service.declaration.ParticipanteMiniCursoService;
import com.sogo.classroom.service.declaration.ParticipanteService;
import com.sogo.classroom.service.exceptions.BusinessException;
import com.sogo.classroom.service.mapper.MiniCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MiniCursoServiceImpl implements MiniCursoService {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private ParticipanteMiniCursoService participanteMiniCursoService;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO) {
        if(this.participanteMiniCursoService.consultarDisponibilidadeDataRealizacao(miniCursoCadastroDTO.getDataRealizacao())) {
            Professor professor = this.professorRepository.findById(miniCursoCadastroDTO.getIdProfessor()).
                    orElseThrow(() -> new NoSuchElementException("Profesor não encontrado"));
            return this.miniCursoRepository.save(MiniCursoMapper.mapper(miniCursoCadastroDTO, professor));
        }
        else {
            throw new BusinessException("O mini curso não pode ser cadastrado nessa data");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MensagemRetornoDTO inscreverParticipanteMiniCurso(Long id, ParticipanteMiniCursoInscricaoDTO participanteMiniCursoInscricaoDTO) throws NoSuchElementException {
        MiniCurso miniCurso = this.miniCursoRepository.findById(id).orElseThrow(NoSuchElementException::new);

        Participante participante = this.participanteService.findById(participanteMiniCursoInscricaoDTO.getIdParticipante()).orElseThrow(NoSuchElementException::new);
        if(this.participanteMiniCursoService.verificarInscricao(participante)){
            throw new BusinessException("Participante já cadastrado ao mini curso");
        }
        miniCurso.setVagasPreenchidas(miniCurso.getVagasPreenchidas()+1);
        this.participanteMiniCursoService.inscreverParticipanteMiniCurso(miniCurso, participante);
        return new MensagemRetornoDTO("Participante Inscrito com sucesso.");
    }

    @Override
    public MiniCurso findById(Long id) {
        return this.miniCursoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Nemhum mini curso encontrado"));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MensagemRetornoDTO atualizar(MiniCurso miniCurso) {
        this.miniCursoRepository.save(miniCurso);
        return new MensagemRetornoDTO("Mini curso atualizado com sucesso");
    }

    @Override
    public List<MiniCursoConsultaDTO> consultarMiniCursosMinistradosProfessor(Long idProfessor) {
        return this.miniCursoRepository.consultarMiniCursosMinistradosProfessor(idProfessor);
    }

    @Override
    public List<MiniCursoConsultaDTO> consultarMiniCursos() {
        return this.miniCursoRepository.findAll().stream().map(item -> new MiniCursoConsultaDTO(item.getId(), item.getNome(),
                item.getDataRealizacao(), item.getDuracaoPrevista(), item.getTotalVagas(), item.getVagasPreenchidas(),
                item.getProfessor().getNome())).collect(Collectors.toList());
    }
}
