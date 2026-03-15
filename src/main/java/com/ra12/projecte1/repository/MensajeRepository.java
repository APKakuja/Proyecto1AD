package com.ra12.projecte1.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ra12.projecte1.model.Mensaje;

@Repository
public class MensajeRepository {

    private final JdbcTemplate jdbcTemplate;

    public MensajeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Mensaje mensaje) {
        String sql = "INSERT INTO mensaje (chat_id, texto, enviado_por_mi, fecha) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            mensaje.getChatId(),
            mensaje.getTexto(),
            mensaje.isEnviadoPorMi(),
            Timestamp.valueOf(mensaje.getFecha())
        );
    }

    public List<Mensaje> findByChatId(int chatId) {
        String sql = "SELECT * FROM mensaje WHERE chat_id = ? ORDER BY fecha ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Mensaje m = new Mensaje();
            m.setId(rs.getInt("id"));
            m.setChatId(rs.getInt("chat_id"));
            m.setTexto(rs.getString("texto"));
            m.setEnviadoPorMi(rs.getBoolean("enviado_por_mi"));
            m.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            return m;
        }, chatId);
    }
}