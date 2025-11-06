CREATE DATABASE st_04_negozio;
USE st_04_negozio;

CREATE TABLE Persona(
	personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    email VARCHAR(250)
);

CREATE TABLE Carta(
	cartaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(10) NOT NULL,
    negozio VARCHAR(250),
    personaRIF INTEGER NOT NULL,
    FOREIGN KEY (personaRIF) REFERENCES Persona(personaID) ON DELETE CASCADE
);

-- Inserimenti nella tabella Persona
INSERT INTO Persona (nominativo, email) VALUES
('Mario Rossi', 'mario.rossi@email.com'),
('Luca Bianchi', 'luca.bianchi@email.com'),
('Giulia Verdi', 'giulia.verdi@email.com'),
('Francesca Neri', 'francesca.neri@email.com'),
('Alessandro Conti', 'alessandro.conti@email.com'),
('Chiara Romano', 'chiara.romano@email.com'),
('Paolo De Luca', 'paolo.deluca@email.com'),
('Elena Galli', 'elena.galli@email.com'),
('Federico Moretti', 'federico.moretti@email.com'),
('Sara Esposito', 'sara.esposito@email.com');

-- Inserimenti nella tabella Carta
INSERT INTO Carta (codice, negozio, personaRIF) VALUES
('C0001', 'MediaWorld', 1),
('C0002', 'Amazon', 1),
('C0003', 'IKEA', 2),
('C0004', 'Amazon', 2),
('C0005', 'Zara', 3),
('C0006', 'MediaWorld', 3),
('C0007', 'H&M', 4),
('C0008', 'IKEA', 4),
('C0009', 'Decathlon', 5),
('C0010', 'Amazon', 5),
('C0011', 'Nike', 6),
('C0012', 'Zara', 6),
('C0013', 'Apple Store', 7),
('C0014', 'MediaWorld', 7),
('C0015', 'Carrefour', 8),
('C0016', 'Conad', 8),
('C0017', 'Feltrinelli', 9),
('C0018', 'Amazon', 9),
('C0019', 'GameStop', 10),
('C0020', 'Zara', 10);

SELECT *
	FROM Persona
    JOIN Carta ON Persona.personaID = Carta.personaRIF;
    
SELECT * FROM Carta;
