CREATE TABLE material(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  fk_tipo BIGSERIAL NOT NULL,
  fk_status_material BIGSERIAL NOT NULL,
  fk_categoria BIGSERIAL NOT NULL,
  nome VARCHAR (30),
  quantidade VARCHAR(20),
  tombo VARCHAR(30),
  validade DATE,
  descricao VARCHAR(100),
  localizacao VARCHAR(100)

  );


