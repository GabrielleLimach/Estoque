CREATE TABLE status_solicitacoes (
id BIGSERIAL PRIMARY KEY NOT NULL,
status VARCHAR (30)

);
INSERT INTO status_solicitacoes (status) VALUES
    ('Aprovado'),
    ('Cancelado'),
    ('Aguardando Aprovação');