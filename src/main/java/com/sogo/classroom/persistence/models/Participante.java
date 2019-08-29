package com.sogo.classroom.persistence.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sogo_participante")
public class Participante extends Pessoa {

    private static final long serialVersionUID = 6013495136593512706L;

    public Participante() {
        super();
    }

    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "participante", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<ParticipanteMiniCurso> miniCursosInscritos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<ParticipanteMiniCurso> getMiniCursosInscritos() {
        return miniCursosInscritos;
    }

    public void setMiniCursosInscritos(List<ParticipanteMiniCurso> miniCursosInscritos) {
        this.miniCursosInscritos = miniCursosInscritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Participante that = (Participante) o;
        return Objects.equals(cpf, that.cpf) &&
                Objects.equals(dataNascimento, that.dataNascimento) &&
                Objects.equals(miniCursosInscritos, that.miniCursosInscritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, dataNascimento, miniCursosInscritos);
    }
}
