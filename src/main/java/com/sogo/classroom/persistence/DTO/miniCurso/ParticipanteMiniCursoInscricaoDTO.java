package com.sogo.classroom.persistence.DTO.miniCurso;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ParticipanteMiniCursoInscricaoDTO implements Serializable {

    private static final long serialVersionUID = -7235412143999828884L;

    @NotNull
    private Long idParticipante;

    public Long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }
}
