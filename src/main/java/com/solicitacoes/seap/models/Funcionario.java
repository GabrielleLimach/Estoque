package com.solicitacoes.seap.models;

import javax.persistence.*;

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

}
