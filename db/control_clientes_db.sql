CREATE SCHEMA IF NOT EXISTS control_clientes_db;

USE control_clientes_db;

CREATE TABLE cliente (
	id_cliente INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NULL,
    apellido VARCHAR(45) NULL,
    email VARCHAR(45) NULL,
    telefono VARCHAR(45) NULL,
    saldo FLOAT NULL,
    PRIMARY KEY(id_cliente)
);

INSERT INTO `cliente` (`nombre`,`apellido`,`email`,`telefono`,`saldo`)
VALUES
  ("Amber","Goff","mollis.non.cursus@google.edu","1-625-921-8037","983.90"),
  ("Florence","Winters","nulla.tempor.augue@protonmail.edu","(385) 184-4120","840.64"),
  ("Rigel","Finch","ligula.consectetuer@outlook.ca","(282) 383-6688","108.25"),
  ("Declan","Hogan","proin.vel@icloud.com","1-733-843-7163","362.55"),
  ("Kennan","Contreras","curabitur.vel@hotmail.edu","(395) 145-0348","572.20");