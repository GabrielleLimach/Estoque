package com.solicitacoes.seap.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "solicitacaoitem")
public class SolicitacaoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsolicitacaoitem;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "fk_solicitacao")
    private Solicitacao fksolicitacao;

    @ManyToOne
    @JoinColumn(name = "fk_material")
    private Material fkmaterial;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitacaoItem that = (SolicitacaoItem) o;
        return Objects.equals(idsolicitacaoitem, that.idsolicitacaoitem);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsolicitacaoitem);
    }

    public Long getIdsolicitacaoitem() {
        return idsolicitacaoitem;
    }

    public void setIdsolicitacaoitem(Long idsolicitacaoitem) {
        this.idsolicitacaoitem = idsolicitacaoitem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Solicitacao getFksolicitacao() {
        return fksolicitacao;
    }

    public void setFksolicitacao(Solicitacao fksolicitacao) {
        this.fksolicitacao = fksolicitacao;
    }

    public Material getFkmaterial() {
        return fkmaterial;
    }

    public void setFkmaterial(Material fkmaterial) {
        this.fkmaterial = fkmaterial;
    }
}
