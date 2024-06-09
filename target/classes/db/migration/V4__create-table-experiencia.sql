CREATE TABLE experiencia (
    id TEXT PRIMARY KEY,
    empresa VARCHAR NOT NULL,
    cargo VARCHAR NOT NULL,
    descricao VARCHAR NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP,
    user_id TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
