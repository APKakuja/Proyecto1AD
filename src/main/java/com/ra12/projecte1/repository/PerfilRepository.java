package com.ra12.projecte1.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ra12.projecte1.model.Perfil;

@Repository
public class PerfilRepository {

    private final JdbcTemplate jdbcTemplate;

    public PerfilRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Guardar nuevo perfil
    public void save(Perfil perfil) {
        String sql = "INSERT INTO perfil (nombre, descripcion, genero, puesto, skills, experiencia, localizacion, foto_url, edad, created_at) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                perfil.getNombre(),
                perfil.getDescripcion(),
                perfil.getGenero(),
                perfil.getPuesto(),
                perfil.getSkills(),
                perfil.getExperiencia(),
                perfil.getLocalizacion(),
                perfil.getFotoUrl(),
                perfil.getEdad(),
                Timestamp.valueOf(perfil.getCreatedAt())
        );
    }

    // Obtener todos los perfiles
    public List<Perfil> findAll() {
        String sql = "SELECT * FROM perfil";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setGenero(rs.getString("genero"));
            p.setPuesto(rs.getString("puesto"));
            p.setSkills(rs.getString("skills"));
            p.setExperiencia(rs.getString("experiencia"));  // ← CAMBIO
            p.setLocalizacion(rs.getString("localizacion"));
            p.setFotoUrl(rs.getString("foto_url"));
            p.setEdad(rs.getInt("edad"));
            p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return p;
        });
    }

    // Obtener perfil por id
    public Perfil findById(int id) {
        String sql = "SELECT * FROM perfil WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setGenero(rs.getString("genero"));
            p.setPuesto(rs.getString("puesto"));
            p.setSkills(rs.getString("skills"));
            p.setExperiencia(rs.getString("experiencia"));  // ← CAMBIO
            p.setLocalizacion(rs.getString("localizacion"));
            p.setFotoUrl(rs.getString("foto_url"));
            p.setEdad(rs.getInt("edad"));
            p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return p;
        }, id);
    }

    // Actualizar imagen
    public void guardarImagen(int id, String rutaImagen) {
        String sql = "UPDATE perfil SET foto_url = ? WHERE id = ?";
        jdbcTemplate.update(sql, rutaImagen, id);
    }

    // Actualizar perfil por id
    public void actualizarPerfil(int id, Perfil perfil) {
        String sql = "UPDATE perfil SET nombre=?, descripcion=?, genero=?, puesto=?, skills=?, experiencia=?, localizacion=?, edad=?, foto_url=? WHERE id=?";
        jdbcTemplate.update(sql,
                perfil.getNombre(),
                perfil.getDescripcion(),
                perfil.getGenero(),
                perfil.getPuesto(),
                perfil.getSkills(),
                perfil.getExperiencia(),
                perfil.getLocalizacion(),
                perfil.getEdad(),
                perfil.getFotoUrl(),
                id
        );
    }

    // Eliminar perfil por id
    public void eliminarPorId(int id) {
        String sql = "DELETE FROM perfil WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Eliminar todos los perfiles
    public void eliminarTodos() {
        String sql = "DELETE FROM perfil";
        jdbcTemplate.update(sql);
    }
}