package com.ra12.projecte1.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ra12.projecte1.model.Chat;

@Repository
public class ChatRepository {

    private final JdbcTemplate jdbcTemplate;

    public ChatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Crear chat nuevo
    public void save(Chat chat) {
        String sql = "INSERT INTO chat (perfil_id, ultima_frase, fecha_ultimo_mensaje) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                chat.getPerfilId(),
                chat.getUltimaFrase(),
                Timestamp.valueOf(chat.getFechaUltimoMensaje())
        );
    }
      //buscar chats por perfil
    public List<Chat> findByPerfilId(int perfilId) {
        String sql = "SELECT * FROM chat WHERE perfil_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Chat chat = new Chat();
            chat.setId(rs.getInt("id"));
            chat.setPerfilId(rs.getInt("perfil_id"));
            chat.setUltimaFrase(rs.getString("ultima_frase"));
            chat.setFechaUltimoMensaje(rs.getTimestamp("fecha_ultimo_mensaje").toLocalDateTime());
            return chat;
        }, perfilId);
    }

    public Chat findById(int chatId) {
    String sql = "SELECT * FROM chat WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
        Chat chat = new Chat();
        chat.setId(rs.getInt("id"));
        chat.setPerfilId(rs.getInt("perfil_id"));
        chat.setUltimaFrase(rs.getString("ultima_frase"));
        chat.setFechaUltimoMensaje(rs.getTimestamp("fecha_ultimo_mensaje").toLocalDateTime());
        return chat;
    }, chatId);
}

public void deleteById(int id) {
    String sql = "DELETE FROM chat WHERE id = ?";
    jdbcTemplate.update(sql, id);
}

public List<Chat> findAll() {
    String sql = "SELECT * FROM chat";
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
        Chat chat = new Chat();
        chat.setId(rs.getInt("id"));
        chat.setPerfilId(rs.getInt("perfil_id"));
        chat.setUltimaFrase(rs.getString("ultima_frase"));
        chat.setFechaUltimoMensaje(rs.getTimestamp("fecha_ultimo_mensaje").toLocalDateTime());
        return chat;
    });
}
}