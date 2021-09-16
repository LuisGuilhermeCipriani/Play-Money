
INSERT INTO usuario(conta, partida, dataHora, montante, role) 
VALUES('123','Abc@32', '2021-09-15 22:58:14.592', 100,'ADMIN');

INSERT INTO usuario(conta, partida, dataHora, montante, role) 
VALUES('222','abcdef', '2021-09-16 20:48:11.592', 100,'COMUM');

INSERT INTO operacao(conta, partida, dataHora, montante, operacao, destino) 
VALUES('222','abcdef', '2021-09-15 22:58:14.592', 10, 'Pagar', 'Banco');