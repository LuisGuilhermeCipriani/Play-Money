CREATE TABLE IF NOT EXISTS usuario (
    conta VARCHAR(50) PRIMARY KEY,
    partida VARCHAR(6),
    data DATE,
    hora DATE,
    montante FLOAT,
    role VARCHAR(150),
    destino BOOLEAN
);