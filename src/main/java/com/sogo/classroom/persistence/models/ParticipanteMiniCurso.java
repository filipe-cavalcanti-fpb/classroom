package com.sogo.classroom.persistence.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sogo_participante_mini_curso")
public class ParticipanteMiniCurso implements Serializable {

    private static final long serialVersionUID = 3027394325865894496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_mini_curso")
    private MiniCurso miniCurso;

    @ManyToOne
    @JoinColumn(name = "fk_participante")
    private Participante participante;

    @Column(name = "data_inscricao")
    private LocalDateTime dataInscricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MiniCurso getMiniCurso() {
        return miniCurso;
    }

    public void setMiniCurso(MiniCurso miniCurso) {
        this.miniCurso = miniCurso;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipanteMiniCurso)) return false;
        ParticipanteMiniCurso that = (ParticipanteMiniCurso) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getMiniCurso(), that.getMiniCurso()) &&
                Objects.equals(getParticipante(), that.getParticipante()) &&
                Objects.equals(getDataInscricao(), that.getDataInscricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMiniCurso(), getParticipante(), getDataInscricao());
    }

}
