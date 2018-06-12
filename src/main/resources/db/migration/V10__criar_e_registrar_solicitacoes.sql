CREATE TABLE solicitacoes(

  id BIGSERIAL PRIMARY KEY NOT NULL,
  fk_material BIGSERIAL NOT NULL,
  fk_tipo_material BIGSERIAL NOT NULL,
  fk_status_material BIGSERIAL NOT NULL,
  fk_categoria BIGSERIAL NOT NULL,
  fk_funcionario BIGSERIAL NOT NULL,
  fk_tipo_funcionario BIGSERIAL NOT NULL,
  fk_historico BIGSERIAL NOT NULL,
  fk_status_solicitacoes BIGSERIAL NOT NULL,
  fk_setor BIGSERIAL NOT NULL,
  data_entrega DATE,
  data_aprovacao DATE,
  descricao VARCHAR(100)

  );



