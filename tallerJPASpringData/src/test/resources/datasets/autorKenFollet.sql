--AUTORES
INSERT INTO AUTOR (id, nombre) values (1,'Ken Follett');
--CATEGORIAS
INSERT INTO CATEGORIA (id, nombre) values (10,'Ficcion Historica');

--EDITORIALES
INSERT INTO EDITORIAL (id, nombre) values (1,'Planeta');
INSERT INTO EDITORIAL (id, nombre) values (2,'B DE BOOKS');

--LIBROS
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (1,'Los Pilares de la Tierra', 'Descripción de los Pilares de la Tierra', 10, 1, true);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (14,'Triple', 'Descripción de Triple', 10, 2, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (15,'Un Mundo Sin Fin', 'Descripción de Un Mundo Sin Fin', 10, 2, false);

-- INFORMACION ADICIONAL
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (1,'8466341781', 2017, 'Español',1);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (14,'8849759312', 2016, 'Español',14);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (15,'8499893732', 2019, 'Español',15);

-- RELACION AUTOR_LIBRO
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (1, 1);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (14, 1);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (15, 1);

