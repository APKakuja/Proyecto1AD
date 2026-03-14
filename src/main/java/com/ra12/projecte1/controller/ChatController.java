package com.ra12.projecte1.controller;

import com.ra12.projecte1.logging.CustomLogging;
import com.ra12.projecte1.model.Chat;
import com.ra12.projecte1.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    //crear chat
    @PostMapping
    public String crearChat(@RequestParam("perfilId") int perfilId) {
        CustomLogging.info("ChatController", "crearChat", "Creando chat para perfilId=" + perfilId);
        service.crearChat(perfilId);
        return "Chat creado correctamente";
    }

   
    @GetMapping
    public List<Chat> obtenerChats(@RequestParam("perfilId") int perfilId) {
        CustomLogging.info("ChatController", "obtenerChats", "Obteniendo chats del perfilId=" + perfilId);
        return service.obtenerChatsPorPerfil(perfilId);
    }

    @GetMapping("/{id}")
    public Chat obtenerChatPorId(@PathVariable int id) {
    CustomLogging.info("ChatController", "obtenerChatPorId", "Obteniendo chat con id=" + id);
    return service.obtenerChatPorId(id);
}
} 