CREATE TABLE funcionario(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  fk_setor BIGSERIAL NOT NULL,
  fk_tipofuncionario BIGSERIAL NOT NULL,
  nome VARCHAR (30),
  login VARCHAR(20),
  senha VARCHAR(30)

  );

