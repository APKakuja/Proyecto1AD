CREATE TABLE perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    profesion VARCHAR(100),
    skills TEXT,
    experiencia INT,
    localizacion VARCHAR(100),
    foto VARCHAR(255)
);
