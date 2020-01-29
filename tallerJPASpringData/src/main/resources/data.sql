--AUTORES
INSERT INTO AUTOR (id, nombre) values (1,'Ken Follett');
INSERT INTO AUTOR (id, nombre) values (2,'Eva García Sáenz de Urturi');
INSERT INTO AUTOR (id, nombre) values (3,'Astrid Nilsen');
INSERT INTO AUTOR (id, nombre) values (4,'Bram Stoker');
INSERT INTO AUTOR (id, nombre) values (5,'Mary Shelley');
INSERT INTO AUTOR (id, nombre) values (6,'Andy Weir');
INSERT INTO AUTOR (id, nombre) values (7,'Stephen King');
INSERT INTO AUTOR (id, nombre) values (8,'Ernest Cline');
INSERT INTO AUTOR (id, nombre) values (9,'Juan Gómez-Jurado');
INSERT INTO AUTOR (id, nombre) values (10,'Umberto Eco');
INSERT INTO AUTOR (id, nombre) values (11, 'Ben Kane');
INSERT INTO AUTOR (id, nombre) values (12, 'Isaac Asimov');
INSERT INTO AUTOR (id, nombre) values (13, 'Robert Kirkman');
INSERT INTO AUTOR (id, nombre) values (14, 'J.R.R. Tolkien');
INSERT INTO AUTOR (id, nombre) values (15, 'Stieg Larsson');
INSERT INTO AUTOR (id, nombre) values (16, 'Jane Austen');
INSERT INTO AUTOR (id, nombre) values (17, 'Michael Connelly');
INSERT INTO AUTOR (id, nombre) values (18, 'Helena Martin');
--CATEGORIAS
INSERT INTO CATEGORIA (id, nombre) values (1,'Ciencia Ficción');
INSERT INTO CATEGORIA (id, nombre) values (2,'Novela Negra');
INSERT INTO CATEGORIA (id, nombre) values (3,'Terror');
INSERT INTO CATEGORIA (id, nombre) values (4,'Romantica');
INSERT INTO CATEGORIA (id, nombre) values (5,'Ensayo');
INSERT INTO CATEGORIA (id, nombre) values (6,'Cómic');
INSERT INTO CATEGORIA (id, nombre) values (7,'Suspense');
INSERT INTO CATEGORIA (id, nombre) values (8,'Policiaca');
INSERT INTO CATEGORIA (id, nombre) values (9,'Aventuras');
INSERT INTO CATEGORIA (id, nombre) values (10,'Ficcion Historica');
INSERT INTO CATEGORIA (id, nombre) values (11,'Fantasía');
--EDITORIALES
INSERT INTO EDITORIAL (id, nombre) values (1,'Planeta');
INSERT INTO EDITORIAL (id, nombre) values (2,'B DE BOOKS');
INSERT INTO EDITORIAL (id, nombre) values (3,'DEBOLS!LLO');
INSERT INTO EDITORIAL (id, nombre) values (4,'ALFAGUARA');
INSERT INTO EDITORIAL (id, nombre) values (5,'Minotauro');
INSERT INTO EDITORIAL (id, nombre) values (6,'RESERVOIR BOOKS');
INSERT INTO EDITORIAL (id, nombre) values (7,'e-artnow');
INSERT INTO EDITORIAL (id, nombre) values (8,'Nova');
INSERT INTO EDITORIAL (id, nombre) values (9,'Booket');
INSERT INTO EDITORIAL (id, nombre) values (10,'EDHASA');
INSERT INTO EDITORIAL (id, nombre) values (11,'Planeta DeAgostini Cómics');



--LIBROS
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (1,'Los Pilares de la Tierra', 'Descripción de los Pilares de la Tierra', 10, 1, true);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (2,'Los Ritos del Agua', 'Descripción de Los Ritos del Agua', 8, 1, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (3,'El guardián de recuerdos', 'Descripción de El guardián de recuerdos', 1, 1, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (4,'Ready Player One', 'Descripción de Ready Player One', 1, 8, false);

INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (5,'Dracula', 'Descripción de Dracula', 3, 7,false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (6,'El marciano', 'Descripción de El marciano', 1, 1, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (7,'Frankenstein', 'Descripción de Frankenstein', 1, 7, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (8,'Carrie', 'Descripción de Carrie', 3, 3, true);

INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (9,'It', 'Descripción de It', 3, 3, true);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (10,'El Paciente', 'Descripción de El Paciente', 7, 9, true);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (11,'La Leyenda del Ladrón', 'Descripción de La Leyenda del Ladrón', 10, 9, true);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (12,'El Nombre de la Rosa', 'Descripción de El Nombre de la Rosa', 10, 3, false);

INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (13,'La legión olvidada', 'Descripción de La legión olvidada', 10, 2, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (14,'Triple', 'Descripción de Triple', 10, 2, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (15,'Un Mundo Sin Fin', 'Descripción de Un Mundo Sin Fin', 10, 2, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (16,'Yo, Robot', 'Descripción de Yo, Robot', 1, 10, false);

INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (17,'Trilogía de la Fundación', 'Descripción de Trilogía de la Fundación', 1, 3, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (18,'Los muertos vivientes #1: Días pasados','Descripción de Los muertos vivientes #1: Días pasados', 6, 11, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (19,'Los muertos vivientes #2: Días pasados','Descripción de Los muertos vivientes #2: Días pasados', 6, 11, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (20,'Los muertos vivientes #3: Días pasados','Descripción de Los muertos vivientes #3: Días pasados', 6, 11, false);

INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (21,'El señor de los anillos: La Comunidad del anillo','Descripción de El señor de los anillos: La Comunidad del anillo', 11,  5, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (22,'El señor de los anillos: La Dos Torres','Descripción de El señor de los anillos: Las Dos Torres', 11, 5, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (23,'El señor de los anillos: El Retorno del Rey','Descripción de El señor de los anillos: El Retorno del Rey', 11, 5, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (24,'El Hobbit','Descripción de El Hobbit', 11, 5, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (25,'Orgullo y Prejuicio','Descripción de Orgullo y Prejuicio', 4, 3, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (26,'Los hombres que no amaban a las mujeres','Descripción de Los hombres que no amaban a las mujeres', 2, 9, false);
INSERT INTO LIBRO (id, titulo, descripcion, categoria_id, editorial, favorite) values (27,'El eco negro','Descripción de el eco negro', 8, 3, false);


-- INFORMACION ADICIONAL
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (1,'8466341781', 2017, 'Español',1);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (2,'8408169459', 2017, 'Español',2);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (3,'0000000000', 2016, 'Español',3);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (4,'0099560437', 2012, 'Español',4);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (5,'8467036028', 2011, 'Español',5);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (6,'8466655050', 2014, 'Español',6);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (7,'8431671742', 2011, 'Español',7);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (8,'1444720694', 2011, 'Inglés',8);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (9,'8497593790', 2016, 'Español',9);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (10,'8408139312', 2015, 'Español',10);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (11,'8408113127', 2013, 'Español',11);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (12,'8422616467', 1986, 'Español',12);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (13,'8498722411', 2010, 'Español',13);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (14,'8849759312', 2016, 'Español',14);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (15,'8499893732', 2019, 'Español',15);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (16,'8435034828', 2007, 'Español',16);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (17,'849908320X', 2010, 'Español',17);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (18,'846840277X', 2011, 'Español',18);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (19,'8468402788', 2011, 'Español',19);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (20,'8468477680', 2012, 'Español',20);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (21,'8445000667', 2012, 'Español',21);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (22,'8445000675', 2012, 'Español',22);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (23,'8445000683', 2012, 'Español',23);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (24,'8467909226', 2013, 'Español',24);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (25,'6079723956', 2018, 'Español',25);
INSERT INTO INFO_ADICIONAL (id, isbn, fecha_publicacion, idioma,libro) values (26,'8416859221', 2018, 'Español',27);

-- RELACION AUTOR_LIBRO
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (1, 1);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (2, 2);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (3, 3);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (4, 8);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (5, 4);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (6, 6);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (7, 5);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (8, 7);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (9, 7);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (10, 9);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (11, 9);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (12, 10);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (13, 11);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (14, 1);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (15, 1);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (16, 12);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (17, 12);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (18, 13);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (19, 13);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (20, 13);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (21, 14);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (22, 14);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (23, 14);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (24, 14);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (25, 16);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (26, 15);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (27, 17);
INSERT INTO AUTOR_LIBRO (libro_id, autor_id) values (27, 18);

