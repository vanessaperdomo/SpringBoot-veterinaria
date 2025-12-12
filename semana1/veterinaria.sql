CREATE DATABASE veterinaria;
\c veterinaria;

CREATE TABLE Veterinario (
    id_veterinario SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    correo VARCHAR(100)
);

CREATE TABLE Dueno (
    id_dueno SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(150)
);

CREATE TABLE Mascota (
    id_mascota SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(50),
    raza VARCHAR(50),
    edad INT,
    id_dueno INT REFERENCES Dueno(id_dueno)
);

CREATE TABLE Servicio (
    id_servicio SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio NUMERIC(10,2)
);

CREATE TABLE Cita (
    id_cita SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    motivo VARCHAR(200),
    id_mascota INT REFERENCES Mascota(id_mascota),
    id_veterinario INT REFERENCES Veterinario(id_veterinario)
);

CREATE TABLE Diagnostico (
    id_diagnostico SERIAL PRIMARY KEY,
    descripcion TEXT,
    id_cita INT REFERENCES Cita(id_cita)
);

CREATE TABLE Tratamiento (
    id_tratamiento SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    duracion_dias INT,
    id_diagnostico INT REFERENCES Diagnostico(id_diagnostico)
);

CREATE TABLE Medicamento (
    id_medicamento SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    dosis VARCHAR(50)
);

CREATE TABLE Factura (
    id_factura SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    total NUMERIC(10,2),
    id_dueno INT REFERENCES Dueno(id_dueno)
);

CREATE TABLE HistorialMedico (
    id_historial SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    detalle TEXT,
    id_mascota INT REFERENCES Mascota(id_mascota)
);

CREATE TABLE mascota_servicio (
    id_mascota INT REFERENCES Mascota(id_mascota),
    id_servicio INT REFERENCES Servicio(id_servicio),
    PRIMARY KEY (id_mascota, id_servicio)
);

CREATE TABLE tratamiento_medicamento (
    id_tratamiento INT REFERENCES Tratamiento(id_tratamiento),
    id_medicamento INT REFERENCES Medicamento(id_medicamento),
    PRIMARY KEY (id_tratamiento, id_medicamento)
);
