package com.sogo.classroom.persistence.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sogo_participante")
public class Participante extends Pessoa {

    private static final long serialVersionUID = 6013495136593512706L;

    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

    @OneToMany(mappedBy = "participante")
    private List<ParticipanteMiniCurso> miniCursosInscritos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante)) return false;
        if (!super.equals(o)) return false;
        Participante that = (Participante) o;
        return Objects.equals(getCpf(), that.getCpf()) &&
                Objects.equals(getDataNascimento(), that.getDataNascimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCpf(), getDataNascimento());
    }

    public List<ParticipanteMiniCurso> getMiniCursosInscritos() {
        return miniCursosInscritos;
    }

    public void setMiniCursosInscritos(List<ParticipanteMiniCurso> miniCursosInscritos) {
        this.miniCursosInscritos = miniCursosInscritos;
    }
}
