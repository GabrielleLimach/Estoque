package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfuncionario;
    private String nome;
    private String login;
    private String senha;

    @ManyToOne // um cargo possui n funcionarios
    @JoinColumn(name = "fk_cargo")
    private Cargo fkcargo;

    @ManyToOne

    @JoinColumn(name = "fk_setor")
    private Setor fksetor;

    public Long getIdfuncionario() {
        return idfuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(idfuncionario, that.idfuncionario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idfuncionario);
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getFkcargo() {
        return fkcargo;
    }

    public void setFkcargo(Cargo fkcargo) {
        this.fkcargo = fkcargo;
    }

    public Setor getFksetor() {
        return fksetor;
    }

    public void setFksetor(Setor fksetor) {
        this.fksetor = fksetor;
    }

}
