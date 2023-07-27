CREATE TABLE vet_medico(
	id_medico int AUTO_INCREMENT primary key,
	nombre varchar(20) not null,
	apellido_paterno varchar(20) not null,
	apellido_materno varchar(20) not null,
	cedula varchar(20) not null
);


CREATE TABLE vet_paciente(
	id_paciente int AUTO_INCREMENT primary key,
	nombre varchar(20) not null,
	id_tipo_paciente char(1) not null,
	fecha_nacimiento date null,
	id_propietario int not null,
	foreign key (id_propietario) references vet_propietario(id_propietario),
	foreign key (id_tipo_paciente) references cat_tipo_paciente(id_tipo_paciente)
);

CREATE TABLE cat_tipo_paciente(
	id_tipo_paciente char(1) primary key,
	nombre varchar(20) not null
);

CREATE TABLE vet_propietario(
	id_propietario int AUTO_INCREMENT primary key,
	nombre varchar(20) not null,
	apellido_paterno varchar(20) not null,
	apellido_materno varchar(20) not null,
	telefono varchar(10)
);

CREATE TABLE vet_cita(
	id_cita int AUTO_INCREMENT primary key,
	id_paciente int not null,
	id_medico int not null,
	fecha timestamp not null,
	foreign key (id_paciente) references vet_paciente(id_paciente),
	foreign key (id_medico) references vet_medico(id_medico)
);


INSERT INTO cat_tipo_paciente (id_tipo_paciente, nombre) VALUES('G', 'GATO');
INSERT INTO cat_tipo_paciente (id_tipo_paciente, nombre) VALUES('P', 'PERRO');