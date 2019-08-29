package com.sogo.classroom.persistence.models;

import com.sogo.classroom.util.ConstantesModelUtil;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sogo_professor")
public class Professor extends Pessoa{

    private static final long serialVersionUID = 3583466060072178799L;

    @Column(name = "matricula", nullable = false, length = 50)
    private String matricula;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "fk_professor")
    private Set<Telefone> telefones;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getMatricula(), professor.getMatricula()) &&
                Objects.equals(getTelefones(), professor.getTelefones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMatricula(), getTelefones());
    }
}
