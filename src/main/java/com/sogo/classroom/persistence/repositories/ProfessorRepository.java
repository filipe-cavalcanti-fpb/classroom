package com.sogo.classroom.persistence.repositories;

import com.sogo.classroom.persistence.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
