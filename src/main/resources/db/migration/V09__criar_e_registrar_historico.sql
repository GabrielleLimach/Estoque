CREATE TABLE historico (
id BIGSERIAL PRIMARY KEY NOT NULL,
data_inicio DATE,
data_fim DATE,
fk_status_solicitacao BIGSERIAL NOT NULL
);

