
drop database if exists profesorMod;

create database profesorMod;

use profesorMod; 
drop table if exists Direccion;
create table Direccion (
        direccion_Id integer not null AUTO_INCREMENT,
        calle varchar(255),
        numero integer,
        poblacion varchar(255),
        provincia varchar(255) not null,
        primary key (direccion_Id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
drop table if exists Modulo;
create table Modulo (
		modulo_id integer not null AUTO_INCREMENT,
		nombre varchar(225) not null,
		creditos integer not null,
		primary key (modulo_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
	
drop table if exists Profesor;
create table Profesor (
        Id integer not null AUTO_INCREMENT,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        direccion_id integer not null,
        modulo_id integer not null,
        primary key (Id),
        CONSTRAINT FKDireccion FOREIGN KEY (direccion_id) REFERENCES Direccion (direccion_Id),
    	CONSTRAINT FKModulo FOREIGN KEY (modulo_id) REFERENCES Modulo (modulo_id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
  