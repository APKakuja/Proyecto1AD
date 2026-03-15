package com.ra12.projecte1.model;

import java.time.LocalDateTime;

public class Chat {

    private int id;
    private int perfilId; 
    private String ultimaFrase;
    private LocalDateTime fechaUltimoMensaje;
    private String nickname;

    public Chat() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    public String getUltimaFrase() {
        return ultimaFrase;
    }

    public void setUltimaFrase(String ultimaFrase) {
        this.ultimaFrase = ultimaFrase;
    }

    public LocalDateTime getFechaUltimoMensaje() {
        return fechaUltimoMensaje;
    }

    public void setFechaUltimoMensaje(LocalDateTime fechaUltimoMensaje) {
        this.fechaUltimoMensaje = fechaUltimoMensaje;
    }

    public String getNickname() { return nickname; } 
    public void setNickname(String nickname) { this.nickname = nickname; }  
}