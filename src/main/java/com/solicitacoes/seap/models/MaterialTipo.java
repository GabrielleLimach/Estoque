package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "materialtipo")
public class MaterialTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmaterialtipo;
    private String tipo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialTipo that = (MaterialTipo) o;
        return Objects.equals(idmaterialtipo, that.idmaterialtipo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idmaterialtipo);
    }

    public Long getIdmaterialtipo() {
        return idmaterialtipo;
    }

    public void setIdmaterialtipo(Long idmaterialtipo) {
        this.idmaterialtipo = idmaterialtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
