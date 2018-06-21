package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmaterial;
    private String nome;
    private int quantidade;
    private String tombo;
    private LocalDate validade;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_setor")
    private Setor fksetor;

    @ManyToOne
    @JoinColumn(name = "fk_materialtipo")
    private MaterialTipo fkmaterialtipo;

    @ManyToOne
    @JoinColumn(name = "fk_materialstatus")
    private MaterialStatus fkmaterialstatus;

    public Long getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(Long idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTombo() {
        return tombo;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor getFksetor() {
        return fksetor;
    }

    public void setFksetor(Setor fksetor) {
        this.fksetor = fksetor;
    }

    public MaterialTipo getFkmaterialtipo() {
        return fkmaterialtipo;
    }

    public void setFkmaterialtipo(MaterialTipo fkmaterialtipo) {
        this.fkmaterialtipo = fkmaterialtipo;
    }

    public MaterialStatus getFkmaterialstatus() {
        return fkmaterialstatus;
    }

    public void setFkmaterialstatus(MaterialStatus fkmaterialstatus) {
        this.fkmaterialstatus = fkmaterialstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(idmaterial, material.idmaterial);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idmaterial);
    }
}
