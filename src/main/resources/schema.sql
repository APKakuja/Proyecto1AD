
CREATE TABLE IF NOT EXISTS perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    profesion VARCHAR(100),
    skills VARCHAR(255),
    experiencia INT,
    localizacion VARCHAR(100),
    foto VARCHAR(255)
);
