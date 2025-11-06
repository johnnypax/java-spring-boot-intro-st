CREATE DATABASE st_03_lib;
USE st_03_lib;

CREATE TABLE Libri(
	libroID INTEGER PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(250) NOT NULL,
    autore VARCHAR(250),
    anno INTEGER,
    prezzo FLOAT,
    isbn VARCHAR(250)
);

INSERT INTO Libri (titolo, autore, anno, prezzo, isbn)
VALUES ('Il nome della rosa', 'Umberto Eco', 1980, 15.90, '9788845246361');

INSERT INTO Libri (titolo, autore, anno, prezzo, isbn)
VALUES ('Cent\'anni di solitudine', 'Gabriel García Márquez', 1967, 12.50, '9788804325966');

INSERT INTO Libri (titolo, autore, anno, prezzo, isbn)
VALUES ('La coscienza di Zeno', 'Italo Svevo', 1923, 9.99, '9788807900924');

INSERT INTO Libri (titolo, autore, anno, prezzo, isbn)
VALUES ('Orgoglio e pregiudizio', 'Jane Austen', 1813, 11.20, '9788807900184');

INSERT INTO Libri (titolo, autore, anno, prezzo, isbn)
VALUES ('Il Gattopardo', 'Giuseppe Tomasi di Lampedusa', 1958, 13.75, '9788807900153');


SELECT * FROM Libri;