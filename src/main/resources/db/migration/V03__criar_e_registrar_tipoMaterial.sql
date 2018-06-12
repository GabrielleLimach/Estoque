CREATE TABLE tipomaterial(
id BIGSERIAL PRIMARY KEY NOT NULL,
tipo VARCHAR (30)

);
INSERT INTO tipomaterial (tipo) VALUES
    ('Permanente'),
    ('Provisório');