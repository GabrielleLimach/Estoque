package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idcargo;
    private String descricao;

    public Long getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Long idcargo) {
        this.idcargo = idcargo;
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
        Cargo cargo = (Cargo) o;
        return Objects.equals(idcargo, cargo.idcargo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcargo);
    }

}
