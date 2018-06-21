package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "solicitacaostatus")
public class SolicitacaoStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsolicitacaostatus;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitacaoStatus that = (SolicitacaoStatus) o;
        return Objects.equals(idsolicitacaostatus, that.idsolicitacaostatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsolicitacaostatus);
    }

    public Long getIdsolicitacaostatus() {

        return idsolicitacaostatus;
    }

    public void setIdsolicitacaostatus(Long idsolicitacaostatus) {
        this.idsolicitacaostatus = idsolicitacaostatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
