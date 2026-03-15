package com.ra12.projecte1.controller;

import com.ra12.projecte1.logging.CustomLogging;
import com.ra12.projecte1.model.Chat;
import com.ra12.projecte1.model.Mensaje;
import com.ra12.projecte1.service.ChatService;
import com.ra12.projecte1.service.MensajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService service;
    private final MensajeService mensajeService;

    public ChatController(ChatService service, MensajeService mensajeService) {
        this.service = service;
        this.mensajeService = mensajeService;
    }

    @PostMapping
    public String crearChat(@RequestParam("perfilId") int perfilId) {
        CustomLogging.info("ChatController", "crearChat", "Creando chat para perfilId=" + perfilId);
        service.crearChat(perfilId);
        return "Chat creado correctamente";
    }

    @GetMapping
public List<Chat> obtenerChats() {
    CustomLogging.info("ChatController", "obtenerChats", "Obteniendo todos los chats");
    return service.obtenerTodosLosChats();
}

    @GetMapping("/{id}")
    public Chat obtenerChatPorId(@PathVariable int id) {
        CustomLogging.info("ChatController", "obtenerChatPorId", "Obteniendo chat con id=" + id);
        return service.obtenerChatPorId(id);
    }

    // ✅ NUEVO — borrar chat
    @DeleteMapping("/{id}")
    public String borrarChat(@PathVariable int id) {
        CustomLogging.info("ChatController", "borrarChat", "Borrando chat con id=" + id);
        service.borrarChat(id);
        return "Chat eliminado";
    }

    // ✅ NUEVO — obtener mensajes de un chat
    @GetMapping("/{id}/mensajes")
    public List<Mensaje> getMensajesDeChat(@PathVariable int id) {
        CustomLogging.info("ChatController", "getMensajesDeChat", "Obteniendo mensajes del chat id=" + id);
        return mensajeService.obtenerMensajes(id);
    }
}