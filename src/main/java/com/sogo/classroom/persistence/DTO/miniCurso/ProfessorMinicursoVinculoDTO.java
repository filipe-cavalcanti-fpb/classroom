package com.sogo.classroom.persistence.DTO.miniCurso;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProfessorMinicursoVinculoDTO implements Serializable {

    private static final long serialVersionUID = 5958564473854081147L;

    @NotNull
    private Long idMinicurso;

    public Long getIdMinicurso() {
        return idMinicurso;
    }

    public void setIdMinicurso(Long idMinicurso) {
        this.idMinicurso = idMinicurso;
    }
}
