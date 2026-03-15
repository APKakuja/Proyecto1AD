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

    public void crearChat(int perfilId) {
        Chat chat = new Chat();
        chat.setPerfilId(perfilId);
        chat.setUltimaFrase("");
        chat.setFechaUltimoMensaje(LocalDateTime.now());
        repository.save(chat);
    }

    public List<Chat> obtenerChatsPorPerfil(int perfilId) {
        return repository.findByPerfilId(perfilId);
    }

    public List<Chat> obtenerTodosLosChats() {
    return repository.findAll();
}

    public Chat obtenerChatPorId(int chatId) {
        return repository.findById(chatId);
    }

    public void borrarChat(int id) {
        CustomLogging.info("ChatService", "borrarChat", "Borrando chat con id=" + id);
        repository.deleteById(id);
    }
}