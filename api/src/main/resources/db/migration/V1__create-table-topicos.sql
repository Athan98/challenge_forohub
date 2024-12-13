
CREATE TABLE topicos (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         titulo VARCHAR(200) NOT NULL,
                         mensaje VARCHAR(500) NOT NULL,
                         fechaCreacion DATE NOT NULL,
                         nombre VARCHAR(100) NOT NULL,
                         apellido VARCHAR(100) NOT NULL,
                         edad INT NOT NULL,
                         pais VARCHAR(100) NOT NULL,
                         categoria VARCHAR(100) NOT NULL,
                         estado TINYINT(1) NOT NULL, -- Representa un booleano (0 = falso, 1 = verdadero)

                         PRIMARY KEY (id)
);