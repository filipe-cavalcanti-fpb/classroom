package com.sogo.classroom.persistence.repositories;

import com.sogo.classroom.persistence.models.MiniCurso;
import com.sogo.classroom.persistence.models.Participante;
import com.sogo.classroom.persistence.models.ParticipanteMiniCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipanteMiniCursoRepository extends JpaRepository<ParticipanteMiniCurso, Long> {

    @Query("SELECT pmc.miniCurso FROM ParticipanteMiniCurso pmc WHERE pmc.participante.id = :idParticipante")
    List<MiniCurso> consultarMinicursosParticipante(Long idParticipante);

    Boolean existsByParticipante(Participante participante);
}
