CREATE TABLE status_material(
id BIGSERIAL PRIMARY KEY NOT NULL,
status VARCHAR (30)

);
INSERT INTO status_material (status) VALUES
    ('Disponível'),
    ('Indisponível');
