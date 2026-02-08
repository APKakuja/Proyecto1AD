package com.ra12.projecte1.repository;

import com.ra12.projecte1.model.Perfil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerfilRepository {

    private final JdbcTemplate jdbcTemplate;

    public PerfilRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Perfil perfil) {
        String sql = "INSERT INTO perfil (nombre, descripcion, profesion, skills, experiencia, localizacion, foto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                perfil.getNombre(),
                perfil.getDescripcion(),
                perfil.getProfesion(),
                perfil.getSkills(),
                perfil.getExperiencia(),
                perfil.getLocalizacion(),
                perfil.getFoto()
        );
    }

    public List<Perfil> findAll() {
        String sql = "SELECT * FROM perfil";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setProfesion(rs.getString("profesion"));
            p.setSkills(rs.getString("skills"));
            p.setExperiencia(rs.getInt("experiencia"));
            p.setLocalizacion(rs.getString("localizacion"));
            p.setFoto(rs.getString("foto"));
            return p;
        });
    }

    public Perfil findById(int id) {
        String sql = "SELECT * FROM perfil WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setProfesion(rs.getString("profesion"));
            p.setSkills(rs.getString("skills"));
            p.setExperiencia(rs.getInt("experiencia"));
            p.setLocalizacion(rs.getString("localizacion"));
            p.setFoto(rs.getString("foto"));
            return p;
        });
    }

     // Guardar imagen (actualizar la columna "foto")
    public void guardarImagen(int id, String rutaImagen) {
        String sql = "UPDATE perfil SET foto = ? WHERE id = ?";
        jdbcTemplate.update(sql, rutaImagen, id);
    }

    // Update por id
    public void actualizarPerfil(int id, Perfil perfil) {
        String sql = "UPDATE perfil SET nombre=?, descripcion=?, profesion=?, skills=?, experiencia=?, localizacion=? WHERE id=?";
        jdbcTemplate.update(sql,
                perfil.getNombre(),
                perfil.getDescripcion(),
                perfil.getProfesion(),
                perfil.getSkills(),
                perfil.getExperiencia(),
                perfil.getLocalizacion(),
                id
        );
    }

    // Delete por id
    public void eliminarPorId(int id) {
        String sql = "DELETE FROM perfil WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Delete todos los registros
    public void eliminarTodos() {
        String sql = "DELETE FROM perfil";
        jdbcTemplate.update(sql);
    }

}
