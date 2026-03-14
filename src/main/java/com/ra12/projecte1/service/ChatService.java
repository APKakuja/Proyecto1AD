package com.ra12.projecte1.service;

import com.ra12.projecte1.logging.CustomLogging;
import com.ra12.projecte1.model.Chat;
import com.ra12.projecte1.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    private final ChatRepository repository;

    public ChatService(ChatRepository repository) {
        this.repository = repository;
    }

    // Crear un chat al hacer match
    public void crearChat(int perfilId) {
        CustomLogging.info("ChatService", "crearChat", "Creando chat para perfilId=" + perfilId);

        Chat chat = new Chat();
        chat.setPerfilId(perfilId);
        chat.setUltimaFrase(""); 
        chat.setFechaUltimoMensaje(LocalDateTime.now());

        repository.save(chat);

        CustomLogging.info("ChatService", "crearChat", "Chat creado correctamente");
    }
     public List<Chat> obtenerChatsPorPerfil(int perfilId) {
        CustomLogging.info("ChatService", "obtenerChatsPorPerfil", "Obteniendo chats para perfilId=" + perfilId);
        return repository.findByPerfilId(perfilId);
    }

    public Chat obtenerChatPorId(int chatId) {
    CustomLogging.info("ChatService", "obtenerChatPorId", "Buscando chat con id=" + chatId);
    return repository.findById(chatId);
}
}