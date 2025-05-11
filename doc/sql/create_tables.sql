CREATE TABLE epk_db.mapa
(id bigint NOT NULL AUTO_INCREMENT,
 orden int,
 nombre varchar(200),
 surfaces varchar(5000),
 elements varchar(5000),
PRIMARY KEY (id));