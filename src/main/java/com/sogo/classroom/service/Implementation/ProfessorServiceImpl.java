package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.miniCurso.ProfessorMinicursoVinculoDTO;
import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.DTO.professor.ProfessorConsultaDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Professor;
import com.sogo.classroom.persistence.repositories.ProfessorRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import com.sogo.classroom.service.declaration.ProfessorService;
import com.sogo.classroom.service.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private MiniCursoService miniCursoService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Professor saveProfessor(ProfessorCadastroDTO professorCadastroDTO) {
        return professorRepository.save(ProfessorMapper.mapper(professorCadastroDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String vincularProfessorMinicurso(Long idProfessor, ProfessorMinicursoVinculoDTO professorMinicursoVinculoDTO) {
        MiniCurso miniCurso = this.miniCursoService.findById(professorMinicursoVinculoDTO.getIdMinicurso());
        Professor professor = this.findById(idProfessor);
        miniCurso.setProfessor(professor);
        this.miniCursoService.atualizar(miniCurso);
        return "Inclusão realizada";
    }

    @Override
    public Professor findById(Long id) {
        return this.professorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ProfessorConsultaDTO> consultarProfessores() {
        return this.professorRepository.consultarProfessores();
    }

}
