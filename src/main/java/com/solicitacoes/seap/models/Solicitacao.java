package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "solicitacao")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsolicitacao;
    private LocalDate datasolicitacao;
    private String justificativa;

    @ManyToOne
    @JoinColumn(name = "fk_funcionario")
    private Funcionario fkfuncionario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitacao that = (Solicitacao) o;
        return Objects.equals(idsolicitacao, that.idsolicitacao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsolicitacao);
    }

    public Long getIdsolicitacao() {
        return idsolicitacao;
    }

    public void setIdsolicitacao(Long idsolicitacao) {
        this.idsolicitacao = idsolicitacao;
    }

    public LocalDate getDatasolicitacao() {
        return datasolicitacao;
    }

    public void setDatasolicitacao(LocalDate datasolicitacao) {
        this.datasolicitacao = datasolicitacao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Funcionario getFkfuncionario() {
        return fkfuncionario;
    }

    public void setFkfuncionario(Funcionario fkfuncionario) {
        this.fkfuncionario = fkfuncionario;
    }

    public SolicitacaoStatus getFksolcitacaostatus() {
        return fksolcitacaostatus;
    }

    public void setFksolcitacaostatus(SolicitacaoStatus fksolcitacaostatus) {
        this.fksolcitacaostatus = fksolcitacaostatus;
    }

    @ManyToOne
    @JoinColumn(name = "fk_solicitacaostatus")
    private SolicitacaoStatus fksolcitacaostatus;
}
