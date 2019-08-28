package com.sogo.classroom.persistence.repositories;

import com.sogo.classroom.persistence.models.MiniCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiniCursoRepository extends JpaRepository<MiniCurso, Long> {
}
