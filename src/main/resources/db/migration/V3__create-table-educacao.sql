CREATE TABLE educacao (
    id TEXT PRIMARY KEY,
    instituicao VARCHAR NOT NULL,
    curso VARCHAR NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_conclusao TIMESTAMP,
    user_id TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
