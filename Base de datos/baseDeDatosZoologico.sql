DROP DATABASE IF EXISTS baseDatosZoologico;
CREATE DATABASE baseDatosZoologico;
use baseDatosZoologico;


CREATE TABLE usuarios (
id int auto_increment ,
nombre VARCHAR (40),
apellidos VARCHAR (40),
fechaNacimiento DATE,
contrasena VARCHAR (25),
PRIMARY KEY (id)
);

select * from usuarios;

CREATE TABLE altaPrimate (
id int auto_increment,
nombre VARCHAR (40),
fechaNacimiento DATE,
motivoAlta VARCHAR (100),
fechaAlta DATE,
GENERO boolean,
CUIDADOS VARCHAR (200),
PRIMARY KEY(id)
);

select * from altaPrimate;


CREATE TABLE bajaPrimate (
id int auto_increment,
nombre VARCHAR (40),
fechaNacimiento DATE,
motivoBaja VARCHAR (100),
fechaBaja DATE,
GENERO boolean,
CUIDADOS VARCHAR (200),
PRIMARY KEY(id)
);

select * from bajaPrimate;


CREATE TABLE altaReptil (
id int auto_increment,
nombre VARCHAR (40),
fechaNacimiento DATE,
motivoAlta VARCHAR (40),
fechaAlta DATE,
tipoPiel BOOLEAN,
cuidados VARCHAR (200),
PRIMARY KEY (id)
);

select * from altaReptil;

CREATE TABLE bajaReptil (
id int auto_increment,
nombre VARCHAR (40),
fechaNacimiento DATE,
motivoBaja VARCHAR (40),
fechaBaja DATE,
tipoPiel BOOLEAN,
cuidados VARCHAR (200),
PRIMARY KEY (id)
);

select * from bajaReptil;

CREATE TABLE altaAnfibio (
id int auto_increment,
nombre VARCHAR (40),
fechaNacimiento DATE,
motivoAlta VARCHAR (40),
fechaAlta DATE,
tipoOrden VARCHAR (40),
tipoAmbiente BOOLEAN,
cuidados VARCHAR (200),
PRIMARY KEY (id)
);

select * from altaAnfibio;


CREATE TABLE bajaAnfibio (
id int auto_increment,
nombre VARCHAR (40),
fechaNacimiento DATE,
motivoBaja VARCHAR (40),
fechaBaja DATE,
tipoOrden VARCHAR (40),
tipoAmbiente BOOLEAN,
cuidados VARCHAR (200),
PRIMARY KEY (id)
);

select * from bajaAnfibio;

CREATE TABLE alimento (
id int auto_increment,
nombre VARCHAR(40),
tipoAlimento VARCHAR (40),
cantidadAlimento NUMERIC (4,1),
PRIMARY KEY (id)
);

select * from alimento;

