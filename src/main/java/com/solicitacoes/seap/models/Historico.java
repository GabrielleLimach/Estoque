package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhistorico;
    private LocalDate data;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_solicitacao")
    private Solicitacao fksolicitacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Historico historico = (Historico) o;
        return Objects.equals(idhistorico, historico.idhistorico);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idhistorico);
    }

    public Long getIdhistorico() {

        return idhistorico;
    }

    public void setIdhistorico(Long idhistorico) {
        this.idhistorico = idhistorico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Solicitacao getFksolicitacao() {
        return fksolicitacao;
    }

    public void setFksolicitacao(Solicitacao fksolicitacao) {
        this.fksolicitacao = fksolicitacao;
    }

}
