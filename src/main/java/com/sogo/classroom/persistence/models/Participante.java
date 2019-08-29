package com.sogo.classroom.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sogo_participante")
public class Participante extends Pessoa {

    private static final long serialVersionUID = 6013495136593512706L;

    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

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

}
