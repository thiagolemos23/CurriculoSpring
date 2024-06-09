CREATE TABLE users_tecnologias (
    id SERIAL PRIMARY KEY,
    users_id TEXT,
    tecnologias TEXT,
    FOREIGN KEY (users_id) REFERENCES users(id)
);
