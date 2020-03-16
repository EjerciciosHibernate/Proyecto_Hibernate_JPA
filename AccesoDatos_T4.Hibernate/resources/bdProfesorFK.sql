
drop database if exists profesorfk;

create database profesorfk;

use profesorfk; 
drop table if exists Direccionfk;
create table Direccionfk (
        direccion_Id integer not null AUTO_INCREMENT,
        calle varchar(255),
        numero integer,
        poblacion varchar(255),
        provincia varchar(255) not null,
        primary key (direccion_Id)
        
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
drop table if exists Profesorfk;
create table Profesorfk (
        Id integer not null AUTO_INCREMENT,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        direccion_id integer not null,
        primary key (Id),
        CONSTRAINT FKDireccion FOREIGN KEY (direccion_id) REFERENCES DireccionFK (direccion_Id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;