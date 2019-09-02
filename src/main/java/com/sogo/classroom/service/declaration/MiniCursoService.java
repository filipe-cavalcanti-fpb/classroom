package com.sogo.classroom.service.declaration;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoConsultaDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.ParticipanteMiniCursoInscricaoDTO;
import com.sogo.classroom.persistence.DTO.response.MensagemRetornoDTO;
import com.sogo.classroom.persistence.models.MiniCurso;

import java.util.List;
import java.util.NoSuchElementException;

public interface MiniCursoService {

    MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO);

    MensagemRetornoDTO inscreverParticipanteMiniCurso(Long id, ParticipanteMiniCursoInscricaoDTO participanteMiniCursoInscricaoDTO) throws NoSuchElementException;

    MiniCurso findById(Long id);

    MensagemRetornoDTO atualizar(MiniCurso miniCurso);

    List<MiniCursoConsultaDTO> consultarMiniCursosMinistradosProfessor(Long idProfessor);

    List<MiniCursoConsultaDTO> consultarMiniCursos();

}
