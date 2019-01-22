INSERT INTO countries (id,name,created_at) VALUES('1','Chile','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('2','Argentina','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('3','Brasil','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('4','Uruguay','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('5','Finlandia','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('6','Alemania','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('7','Australia','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('8','Nueva Zelanda','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('9','Ucrania','2018-10-28');
INSERT INTO countries (id,name,created_at) VALUES('10','Holanda','2018-10-28');

INSERT INTO genres (id,name,created_at) VALUES('1','Hombre','2018-10-28');
INSERT INTO genres (id,name,created_at) VALUES('2','Mujer','2018-10-28');
INSERT INTO genres (id,name,created_at) VALUES('3','Otro','2018-10-28');

INSERT INTO roles (id,name,description,created_at) VALUES('1','SuperAdmin','Super administrador con todos los permisos','2018-10-28');
INSERT INTO roles (id,name,description,created_at) VALUES('2','Admin','Administrador con casi todos los permisos','2018-10-28');
INSERT INTO roles (id,name,description,created_at) VALUES('3','User','Usuario con permisos muy limitados','2018-10-28');

INSERT INTO artists (id, name, born_date, country_id, genre_id, photo, created_at) VALUES ('1', 'CandleBox', '1991-10-28', '6', '1', null, '2018-11-25');

INSERT INTO albums (id, name, creation_date, artist_id, photo, created_at) VALUES ('1', 'CandleBox', '1993-01-01', '1', null, '2018-11-25');

INSERT INTO demos (id, name, artist_id, photo, created_at) VALUES ('1', 'You', '1', null, '2018-11-25');

INSERT INTO songs (id, name, album_id, collaboration, created_at) VALUES ('1', 'You', '1', 'false', '2018-11-25');

INSERT INTO users (id, name, email, password, rol_id, created_at) VALUES ('1', 'Nicolas', 'nicolas@mail.com', '123123', '1', '2018-11-25');