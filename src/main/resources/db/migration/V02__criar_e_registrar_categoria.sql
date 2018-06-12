CREATE TABLE categoria(
id BIGSERIAL PRIMARY KEY NOT NULL,
nome VARCHAR (30)

);
INSERT INTO categoria (nome) VALUES
    ('Unidade'),
    ('Caixa'),
    ('Pacote');
