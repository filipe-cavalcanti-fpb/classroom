package com.sogo.classroom.persistence.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sogo_mini_curso")
public class MiniCurso implements Serializable {

    private static final long serialVersionUID = -9151779811424490027L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "data_realizacao", nullable = false, unique = false)
    private LocalDateTime dataRealizacao;

    @Column(name = "duracao_prevista", nullable = false)
    private LocalTime duracaoPrevista;

    @Column(name = "total_vagas", nullable = false)
    private Integer totalVagas;

    @OneToMany(mappedBy = "miniCurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipanteMiniCurso> participantesMiniCurso;

    @Column(name = "vagas_preenchidas", nullable = false)
    private Integer vagasPreenchidas;

    @ManyToOne
    @JoinColumn(name = "fk_professor")
    private Professor professor;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiniCurso)) return false;
        MiniCurso miniCurso = (MiniCurso) o;
        return getId().equals(miniCurso.getId()) &&
                Objects.equals(getNome(), miniCurso.getNome()) &&
                Objects.equals(getDataRealizacao(), miniCurso.getDataRealizacao()) &&
                Objects.equals(getDuracaoPrevista(), miniCurso.getDuracaoPrevista()) &&
                Objects.equals(getTotalVagas(), miniCurso.getTotalVagas()) &&
                Objects.equals(getVagasPreenchidas(), miniCurso.getVagasPreenchidas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDataRealizacao(), getDuracaoPrevista(), getTotalVagas(), getVagasPreenchidas());
    }

    public List<ParticipanteMiniCurso> getParticipantesMiniCurso() {
        return participantesMiniCurso;
    }

    public void setParticipantesMiniCurso(List<ParticipanteMiniCurso> participantesMiniCurso) {
        this.participantesMiniCurso = participantesMiniCurso;
    }
}
