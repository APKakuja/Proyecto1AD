package com.ra12.projecte1.model;

import java.time.LocalDateTime;

public class Perfil {

    private int id;
    private String nombre;
    private String descripcion;
    private String genero;
    private String puesto;
    private String skills;
    private String experiencia;  // ← CAMBIO: de int a String
    private String localizacion;
    private String fotoUrl;
    private int edad;
    private LocalDateTime createdAt;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getExperiencia() { return experiencia; }  // ← CAMBIO
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }  // ← CAMBIO

    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}