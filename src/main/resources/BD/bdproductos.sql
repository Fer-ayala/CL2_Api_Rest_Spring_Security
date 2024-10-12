create database bdproductos;
use bdproductos;

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

CREATE TABLE productos (
    idproducto INT auto_increment NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NULL,
    precio DECIMAL(10, 2) NOT NULL,
    disponible BOOL NOT NULL DEFAULT TRUE,
    CONSTRAINT productos_pk PRIMARY KEY (idproducto)
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

INSERT INTO productos (nombre, descripcion, precio, disponible) VALUES
('Laptop', 'Laptop de 15 pulgadas con 8GB de RAM', 1200.99, TRUE),
('Smartphone', 'Smartphone de última generación con 128GB de almacenamiento', 899.99, TRUE),
('Teclado mecánico', 'Teclado mecánico RGB con switches rojos', 75.50, TRUE),
('Mouse inalámbrico', 'Mouse ergonómico con conexión Bluetooth', 45.00, TRUE),
('Monitor 4K', 'Monitor de 27 pulgadas con resolución 4K', 320.75, TRUE),
('Impresora multifuncional', 'Impresora con escáner y fotocopiadora', 150.00, TRUE),
('Auriculares', 'Auriculares con cancelación de ruido', 89.99, TRUE),
('Cámara web', 'Cámara web HD con micrófono integrado', 65.99, FALSE),
('Disco duro externo', 'Disco duro externo de 1TB', 59.99, TRUE),
('Silla ergonómica', 'Silla ergonómica de oficina con soporte lumbar', 230.00, TRUE);


select * from usuario;
Select * from rol;
select * from usuario_rol;
select * from productos;