package com.sogo.classroom.persistence.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "sogo_mini_curso")
public class MiniCurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_realizacao")
    private LocalDateTime dataRealizacao;

    @Column(name = "duracao_prevista")
    private LocalTime duracaoPrevista;

    @Column(name = "vagas")
    private Integer vagas;

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

    public LocalDateTime getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDateTime dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public LocalTime getDuracaoPrevista() {
        return duracaoPrevista;
    }

    public void setDuracaoPrevista(LocalTime duracaoPrevista) {
        this.duracaoPrevista = duracaoPrevista;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
