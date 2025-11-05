CREATE DATABASE st_02_inventario;
USE st_02_inventario;

CREATE TABLE Prodotto(
	prodottoID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(10) NOT NULL UNIQUE,
    nome VARCHAR(250) NOT NULL,
    prezzo FLOAT
);

SELECT * FROM Prodotto;