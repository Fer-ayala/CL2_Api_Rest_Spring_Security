create database bdseguridad;
use bdseguridad;

CREATE TABLE usuario (
	idusuario INT auto_increment NOT NULL,
	nomusuario varchar(100) NULL,
	email varchar(200) NULL,
	password varchar(300) NULL,
	nombres varchar(100) NULL,
	apellidos varchar(100) NULL,
	activo BOOL NULL,
	CONSTRAINT users_pk PRIMARY KEY (idusuario)
);


CREATE TABLE rol (
	idrol INT auto_increment NOT NULL,
	nomrol varchar(300) NULL,
	CONSTRAINT roles_pk PRIMARY KEY (idrol)
);

CREATE TABLE usuario_rol (
	idusuario INT NOT NULL,
	idrol INT NOT NULL,
	CONSTRAINT user_role_pk PRIMARY KEY (idusuario, idrol),
	CONSTRAINT user_role_FK FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
	CONSTRAINT user_role_FK_1 FOREIGN KEY (idrol) REFERENCES rol(idrol)
);

/* Inserciones de datos */

INSERT INTO rol (idrol, nomrol) VALUES
(1, 'GESTOR'),
(2, 'COORDINADOR');


#contraseña de alice --> password123
#contraseña de bob --> gestorpass
#contraseña de charlie --> coordinadorpass
INSERT INTO usuario (idusuario, nomusuario, email, password, nombres, apellidos, activo) VALUES
(1, 'Alice', 'alice@example.com', '$2a$12$i9z2fJCFUPtRtKbyOvRyweM97WAtIxfPCToX9qMpOOL1G0Ja83gH.', 'Alice', 'Wonderland', TRUE),
(2, 'Bob', 'bob@example.com', '$2a$12$xsbtRdbHr6zU96CVlBUWOuQ.k1QAu9x9I6OP9NfJ5TlHhy8DKcyQy', 'Bob', 'Builder', TRUE),
(3, 'Charlie', 'charlie@example.com', '$2a$12$D.zlevEMcPOqpADuIaAjKeRlypG7jOWOkfKj2VZJZ2SnocaHZmefu', 'Charlie', 'Brown', TRUE);

INSERT INTO usuario_rol values 
(1,1),
(1,2),
(2,1),
(3,2);

select * from usuario;
Select * from rol;
select * from usuario_rol;