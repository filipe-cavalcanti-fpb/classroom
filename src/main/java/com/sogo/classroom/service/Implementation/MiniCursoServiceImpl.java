package com.sogo.classroom.service.Implementation;

import com.sogo.classroom.persistence.DTO.miniCurso.MiniCursoCadastroDTO;
import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.repositories.MiniCursoRepository;
import com.sogo.classroom.service.declaration.MiniCursoService;
import com.sogo.classroom.service.mapper.MiniCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MiniCursoServiceImpl implements MiniCursoService {

    @Autowired
    private MiniCursoRepository miniCursoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MiniCurso saveMiniCurso(MiniCursoCadastroDTO miniCursoCadastroDTO) {
        return this.miniCursoRepository.save(MiniCursoMapper.mapper(miniCursoCadastroDTO));
    }
}
