package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "setor")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsetor;
    private String descricao;

    public Long getIdsetor() {
        return idsetor;
    }

    public void setIdsetor(Long idsetor) {
        this.idsetor = idsetor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setor setor = (Setor) o;
        return Objects.equals(idsetor, setor.idsetor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsetor);
    }
}
