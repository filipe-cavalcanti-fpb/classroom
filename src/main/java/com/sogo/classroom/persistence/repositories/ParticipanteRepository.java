package com.sogo.classroom.persistence.repositories;

import com.sogo.classroom.persistence.models.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
