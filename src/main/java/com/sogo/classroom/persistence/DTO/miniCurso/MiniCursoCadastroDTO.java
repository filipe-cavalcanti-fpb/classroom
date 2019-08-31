package com.sogo.classroom.persistence.DTO.miniCurso;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

public class MiniCursoCadastroDTO implements Serializable {

    private static final long serialVersionUID = -6459368145631381206L;

    @NotNull(message = "O nome não poder ser nulo")
    @NotBlank(message = "O nome não pode ser vázio")
    private String nome;

    @NotNull(message = "A data de realização não pode ser nula")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataRealizacao;

    @NotNull(message = "O atributo não pode ser nulo")
    @Min(value = 0, message = "O atributo não pode ser menor que zero")
    private Byte duracaoPrevista;

    @NotNull(message = "O total de vagas não pode ser nulo")
    @Min(value = 0)
    private Integer totalVagas;

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
}
