CREATE USER 'proy'@'localhost' IDENTIFIED BY 'password';

CREATE DATABASE epk_db;

GRANT ALL PRIVILEGES ON epk_db.* TO 'proy'@'localhost';

USE epk_db;