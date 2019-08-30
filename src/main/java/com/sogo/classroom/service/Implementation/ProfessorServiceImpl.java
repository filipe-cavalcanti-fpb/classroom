package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.professor.ProfessorCadastroDTO;
import com.sogo.classroom.persistence.models.Professor;
import com.sogo.classroom.persistence.repositories.ProfessorRepository;
import com.sogo.classroom.service.declaration.ProfessorService;
import com.sogo.classroom.service.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Professor saveProfessor(ProfessorCadastroDTO professorCadastroDTO) {
        return professorRepository.save(ProfessorMapper.mapper(professorCadastroDTO));
    }
}
