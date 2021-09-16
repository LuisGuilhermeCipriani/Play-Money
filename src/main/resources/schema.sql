CREATE TABLE IF NOT EXISTS usuario (
    conta VARCHAR(50) PRIMARY KEY,
    partida VARCHAR(6),
    dataHora DATETIME,
    montante FLOAT,
    role VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS operacao (
    idOperacao INTEGER PRIMARY KEY AUTO_INCREMENT,
    conta VARCHAR(50),
    partida VARCHAR(6),
    dataHora DATETIME,
    montante FLOAT,
    operacao VARCHAR(50),
    destino VARCHAR(50)
);