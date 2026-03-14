package com.ra12.projecte1.model;

import java.time.LocalDateTime;

public class Mensaje {

    private int id;
    private int chatId;       
    private String texto;
    private boolean enviadoPorMi;
    private LocalDateTime fecha;

    public Mensaje() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEnviadoPorMi() {
        return enviadoPorMi;
    }

    public void setEnviadoPorMi(boolean enviadoPorMi) {
        this.enviadoPorMi = enviadoPorMi;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}