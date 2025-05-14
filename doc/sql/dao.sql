-- seleccionar todos los MapaDTO
SELECT id, orden, nombre
FROM epk_db.mapa ORDER BY orden;

-- seleccionar el MapaDataDTO cuyo id sea uno dado
SELECT id, orden, nombre, surfaces, elements
FROM epk_db.mapa
WHERE id = ?;

-- insertar MapaDataDTO
INSERT INTO epk_db.mapa
(orden, nombre, surfaces, elements)
VALUES ( ?, ?, ?, ?);

-- actualizar MapaDataDTO
UPDATE epk_db.mapa
SET surfaces = ?, elements = ?
WHERE id = ?;

-- eliminar mapa
DELETE FROM epk_db.mapa
WHERE id = ?;