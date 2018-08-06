package com.solicitacoes.seap.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmaterial;

    @NotNull
    @Size(min =3, max = 20)
    private String nome;
    private int quantidade;
    private String tombo;
    private LocalDate validade;

    @ManyToOne
    @JoinColumn(name = "fk_setor")
    private Setor fksetor;

    @ManyToOne
    @JoinColumn(name = "fk_materialtipo")
    private MaterialTipo fkmaterialtipo;

    @ManyToOne
    @JoinColumn(name = "fk_status")
    private MaterialStatus fkmaterialstatus;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria fkcategoria;

    public Categoria getFkcategoria() {
        return fkcategoria;
    }

    public void setFkcategoria(Categoria fkcategoria) {
        this.fkcategoria = fkcategoria;
    }

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
