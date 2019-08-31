package com.sogo.classroom.persistence.models;

import com.sogo.classroom.util.ConstantesModelUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sogo_telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 8567327541705794934L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numero_telefone", nullable = false, length = 50)
    private String numeroTelefone;

    public Telefone(){
        super();
    }

    public Telefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(getId(), telefone.getId()) &&
                Objects.equals(getNumeroTelefone(), telefone.getNumeroTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumeroTelefone());
    }
}
