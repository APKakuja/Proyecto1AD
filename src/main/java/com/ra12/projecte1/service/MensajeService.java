package com.ra12.projecte1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ra12.projecte1.model.Mensaje;
import com.ra12.projecte1.repository.MensajeRepository;

@Service
public class MensajeService {

    private final MensajeRepository repository;

    public MensajeService(MensajeRepository repository) {
        this.repository = repository;
    }

    public void enviarMensaje(Mensaje mensaje) {
        mensaje.setFecha(LocalDateTime.now());
        repository.save(mensaje);
    }

    public List<Mensaje> obtenerMensajes(int chatId) {
        return repository.findByChatId(chatId);
    }
}