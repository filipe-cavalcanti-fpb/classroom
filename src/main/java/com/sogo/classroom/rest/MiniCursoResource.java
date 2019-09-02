package com.sogo.classroom.rest;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoConsultaDTO;
import com.sogo.classroom.persistence.DTO.miniCurso.ParticipanteMiniCursoInscricaoDTO;
import com.sogo.classroom.persistence.DTO.response.MensagemRetornoDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import com.sogo.classroom.service.declaration.ParticipanteMiniCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/mini-cursos")
public class MiniCursoResource {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @Autowired
    private MiniCursoService miniCursoService;

    @Autowired
    private ParticipanteMiniCursoService participanteMiniCursoService;

    @GetMapping
    public List<MiniCursoConsultaDTO> consultarMiniCursos() {
        return this.miniCursoService.consultarMiniCursos();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MiniCurso saveMiniCurso(@Valid @RequestBody MiniCursoCadastroDTO miniCursoCadastroDTO){
        return this.miniCursoService.saveMiniCurso(miniCursoCadastroDTO);
    }

    @PostMapping("{id}/participantes")
    public MensagemRetornoDTO inscreverParticipanteMiniCurso(@PathVariable("id") Long id, @Valid @RequestBody ParticipanteMiniCursoInscricaoDTO participanteMiniCursoInscricaoDTO) {
        return this.miniCursoService.inscreverParticipanteMiniCurso(id, participanteMiniCursoInscricaoDTO);
    }

    @GetMapping("/alunos/{idParticipante}")
    public List<MiniCurso> consultarMinicursosParticipante(@PathVariable("idParticipante") Long idParticipante){
        return this.participanteMiniCursoService.consultarMinicursosParticipante(idParticipante);
    }
}
