CREATE TABLE IF NOT EXISTS usuario (
    conta VARCHAR(50) PRIMARY KEY,
    partida VARCHAR(6),
    data DATE,
    hora DATE,
    montante FLOAT,
    role VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS operacao (
    conta VARCHAR(50) PRIMARY KEY,
    partida VARCHAR(6),
    data DATE,
    hora DATE,
    montante FLOAT,
    operacao VARCHAR(50)
);