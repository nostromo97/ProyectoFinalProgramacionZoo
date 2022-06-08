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


select * from usuarios;
insert into usuarios values(null,'nombre','asdasd','25-08-1993',12345678);

