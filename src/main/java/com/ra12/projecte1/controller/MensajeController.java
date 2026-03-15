package com.ra12.projecte1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra12.projecte1.model.Mensaje;
import com.ra12.projecte1.service.MensajeService;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final MensajeService service;

    public MensajeController(MensajeService service) {
        this.service = service;
    }

    
    @PostMapping
public Mensaje enviarMensaje(@RequestBody Mensaje mensaje) {
    service.enviarMensaje(mensaje);
    return mensaje; 
}
}