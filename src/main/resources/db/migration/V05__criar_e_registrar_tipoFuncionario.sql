CREATE TABLE tipofuncionario(
id BIGSERIAL PRIMARY KEY NOT NULL,
tipo VARCHAR (30)

);
INSERT INTO tipofuncionario (tipo) VALUES
    ('Administrador'),
    ('Gerente');