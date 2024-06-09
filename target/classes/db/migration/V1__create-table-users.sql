CREATE TABLE users (
    id TEXT PRIMARY KEY,
    nome VARCHAR NOT NULL,
    sobrenome VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    telefone VARCHAR,
    tecnologias TEXT[]
);
