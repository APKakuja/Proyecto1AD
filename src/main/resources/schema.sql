CREATE TABLE IF NOT EXISTS perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    genero VARCHAR(50),
    puesto VARCHAR(100),
    skills VARCHAR(255),
    experiencia INT,
    localizacion VARCHAR(100),
    foto_url VARCHAR(255),
    edad INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    perfil_id INT NOT NULL,
    ultima_frase VARCHAR(255),
    fecha_ultimo_mensaje TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id) ON DELETE CASCADE
);


Adrian Petrisor Kakuja
	
dt., 10 de març 18:21 (fa 4 dies)
	
	
per a mi
Sembla que aquest missatge està en anglès

Tabla perfil:
sql

CREATE TABLE IF NOT EXISTS perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    genero VARCHAR(50),
    puesto VARCHAR(100),
    skills VARCHAR(255),
    experiencia INT,
    localizacion VARCHAR(100),
    foto_url VARCHAR(255),
    edad INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



Tabla chat:
sql

CREATE TABLE IF NOT EXISTS chat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    perfil_id INT NOT NULL,
    ultima_frase VARCHAR(255),
    fecha_ultimo_mensaje TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS mensaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    texto TEXT NOT NULL,
    enviado_por_mi BOOLEAN NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (chat_id) REFERENCES chat(id) ON DELETE CASCADE
);