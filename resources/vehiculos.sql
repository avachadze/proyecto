create table serie(
codigoSerie smallInt(3),
marca varchar (10),
modelo varchar (10),
añoFabricacion smallInt (4),
primary key (codigoSerie)
);

CREATE TABLE Vehiculos(
matricula varchar(7) ,
numBastidor int(20),
color varchar(11),
tipo varchar(8),
numAsientos smallint(2),
precio REAL,
codigoSerie smallInt(2),
PRIMARY KEY (matricula),
FOREIGN KEY (codigoSerie) REFERENCES serie(codigoSerie)
);

CREATE TABLE Coches (
  matricula varchar(7),
  numPuertas smallint(2),
  capacidadMaletero int (4),
  primary key (matricula),
  FOREIGN KEY (matricula) REFERENCES vehiculos(matricula)
  on delete cascade
);

CREATE TABLE Camiones (
  matricula varchar(7),
  carga float (4),
  tipoMercancia char,
  PRIMARY KEY (matricula),
  FOREIGN KEY (matricula) REFERENCES vehiculos(matricula)
  on delete cascade
);

