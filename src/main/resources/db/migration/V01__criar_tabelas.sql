CREATE TABLE cargo(
  idcargo BIGSERIAL PRIMARY KEY NOT NULL,
  descricao VARCHAR (30)
);

CREATE TABLE categoria(
  idcategoria BIGSERIAL PRIMARY KEY NOT NULL,
  descricao varchar(30)
);

CREATE TABLE setor(
  idsetor BIGSERIAL PRIMARY KEY NOT NULL,
  descricao VARCHAR (30)
);

CREATE TABLE materialtipo(
  idmaterialtipo BIGSERIAL PRIMARY KEY NOT NULL,
  tipo VARCHAR (30)
);

CREATE TABLE materialstatus(
  idmaterialstatus BIGSERIAL PRIMARY KEY NOT NULL,
  status VARCHAR (30)
);

CREATE TABLE funcionario(
  idfuncionario BIGSERIAL PRIMARY KEY NOT NULL,
  nome VARCHAR (30),
  login VARCHAR(30),
  senha VARCHAR(30),
  fk_setor BIGSERIAL NOT NULL,
  fk_cargo BIGSERIAL NOT NULL
);

CREATE TABLE material(
  idmaterial BIGSERIAL PRIMARY KEY NOT NULL,
  nome VARCHAR (30),
  quantidade INT,
  tombo VARCHAR(30),
  validade DATE,
  fk_setor BIGSERIAL NOT NULL,
  fk_materialtipo BIGSERIAL NOT NULL,
  fk_status BIGSERIAL NOT NULL,
  fk_categoria BIGSERIAL NOT NULL
);

CREATE TABLE solicitacao (
  idsolicitacao BIGSERIAL PRIMARY KEY NOT NULL,
  data DATE,
  destino VARCHAR(30),
  justificativa VARCHAR(100),
  fk_funcionario BIGSERIAL NOT NULL,
  fk_solicitacaostatus BIGSERIAL NOT NULL
);

CREATE TABLE solicitacaoitem (
  idsolicitacaoitem BIGSERIAL PRIMARY KEY NOT NULL,
  data DATE,
  quantidade INT,
  fk_solicitacao BIGSERIAL NOT NULL,
  fk_material BIGSERIAL NOT NULL
);

CREATE TABLE solicitacaostatus (
  idsolicitacaoestatus BIGSERIAL PRIMARY KEY NOT NULL,
  status VARCHAR (30)
);

CREATE TABLE historico (
  idshistorico BIGSERIAL PRIMARY KEY NOT NULL,
  data DATE,
  descricao VARCHAR (100),
  fk_solicitacao BIGSERIAL NOT NULL
);