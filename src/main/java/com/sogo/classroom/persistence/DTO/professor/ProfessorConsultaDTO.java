package com.sogo.classroom.persistence.DTO.professor;

import java.io.Serializable;

public class ProfessorConsultaDTO implements Serializable {

    private static final long serialVersionUID = -8142956188512942040L;

    private Long id;

    private String nome;

    public ProfessorConsultaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
