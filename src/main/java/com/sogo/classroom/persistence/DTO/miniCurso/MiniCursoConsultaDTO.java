package com.sogo.classroom.persistence.DTO.miniCurso;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MiniCursoConsultaDTO implements Serializable {

    private static final long serialVersionUID = 2470917987571795597L;

    private String nome;

    private LocalDateTime dataRealizacao;

    private Byte duracaoPrevista;

    private Integer totalVagas;

    private Integer vagasPreenchidas;

    public MiniCursoConsultaDTO(String nome, LocalDateTime dataRealizacao, Byte duracaoPrevista, Integer totalVagas, Integer vagasPreenchidas) {
        this.nome = nome;
        this.dataRealizacao = dataRealizacao;
        this.duracaoPrevista = duracaoPrevista;
        this.totalVagas = totalVagas;
        this.vagasPreenchidas = vagasPreenchidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDateTime dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public Byte getDuracaoPrevista() {
        return duracaoPrevista;
    }

    public void setDuracaoPrevista(Byte duracaoPrevista) {
        this.duracaoPrevista = duracaoPrevista;
    }

    public Integer getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(Integer totalVagas) {
        this.totalVagas = totalVagas;
    }

    public Integer getVagasPreenchidas() {
        return vagasPreenchidas;
    }

    public void setVagasPreenchidas(Integer vagasPreenchidas) {
        this.vagasPreenchidas = vagasPreenchidas;
    }
}
