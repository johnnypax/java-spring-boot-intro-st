DROP DATABASE IF EXISTS st_06_lib;
CREATE DATABASE st_06_lib;
USE st_06_lib;

CREATE TABLE Autori(
	autoreID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    bio TEXT,
    codice VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Libri(
	libroID INTEGER PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(250) NOT NULL,
    prezzo FLOAT,
    isbn VARCHAR(250) UNIQUE NOT NULL,
    anno INTEGER,
    autoreRIF INTEGER NOT NULL,
    FOREIGN KEY (autoreRIF) REFERENCES Autori(autoreID) ON DELETE CASCADE
);

-- Inserimento di 10 autori
INSERT INTO Autori (nome, bio, codice) VALUES
('Umberto Eco', 'Scrittore e semiologo italiano', 'AUT001'),
('Italo Calvino', 'Narratore e saggista italiano', 'AUT002'),
('J.K. Rowling', 'Autrice britannica della saga di Harry Potter', 'AUT003'),
('George Orwell', 'Scrittore e giornalista inglese', 'AUT004'),
('Jane Austen', 'Romanziera inglese', 'AUT005'),
('Gabriel García Márquez', 'Scrittore colombiano, premio Nobel', 'AUT006'),
('Haruki Murakami', 'Scrittore giapponese contemporaneo', 'AUT007'),
('Stephen King', 'Scrittore statunitense di horror e thriller', 'AUT008'),
('Dante Alighieri', 'Poeta italiano, autore della Divina Commedia', 'AUT009'),
('Leo Tolstoy', 'Scrittore russo, autore di Guerra e Pace', 'AUT010');

-- Inserimento di 20 libri (2 per autore)
INSERT INTO Libri (titolo, prezzo, isbn, anno, autoreRIF) VALUES
('Il nome della rosa', 18.50, 'ISBN001', 1980, 1),
('Baudolino', 16.00, 'ISBN002', 2000, 1),

('Il barone rampante', 14.90, 'ISBN003', 1957, 2),
('Le città invisibili', 15.50, 'ISBN004', 1972, 2),

('Harry Potter e la pietra filosofale', 20.00, 'ISBN005', 1997, 3),
('Harry Potter e i doni della morte', 22.00, 'ISBN006', 2007, 3),

('1984', 12.90, 'ISBN007', 1949, 4),
('La fattoria degli animali', 11.50, 'ISBN008', 1945, 4),

('Orgoglio e pregiudizio', 13.00, 'ISBN009', 1813, 5),
('Emma', 14.00, 'ISBN010', 1815, 5),

('Cent’anni di solitudine', 17.50, 'ISBN011', 1967, 6),
('L’amore ai tempi del colera', 16.90, 'ISBN012', 1985, 6),

('Norwegian Wood', 15.00, 'ISBN013', 1987, 7),
('Kafka sulla spiaggia', 18.00, 'ISBN014', 2002, 7),

('Shining', 16.50, 'ISBN015', 1977, 8),
('It', 19.90, 'ISBN016', 1986, 8),

('Divina Commedia', 25.00, 'ISBN017', 1320, 9),
('Vita nuova', 14.00, 'ISBN018', 1295, 9),

('Guerra e Pace', 24.00, 'ISBN019', 1869, 10),
('Anna Karenina', 23.00, 'ISBN020', 1877, 10);

SELECT * FROM Libri
	JOIN Autori ON Libri.autoreRIF = Autori.autoreID;
