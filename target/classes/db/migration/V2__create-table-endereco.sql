CREATE TABLE endereco (
    id TEXT PRIMARY KEY,
    rua VARCHAR NOT NULL,
    cidade VARCHAR NOT NULL,
    estado VARCHAR NOT NULL,
    codigo_postal VARCHAR NOT NULL,
    pais VARCHAR NOT NULL,
    user_id TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
