package com.ra12.projecte1.controller;

import com.ra12.projecte1.dto.PerfilDTO;
import com.ra12.projecte1.model.Perfil;
import com.ra12.projecte1.service.PerfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService service;
    private final Logger logger = LoggerFactory.getLogger(PerfilController.class);

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @PostMapping("/csv")
    public String importarCSV(@RequestParam("file") MultipartFile file) {
        try {
            logger.info("Importando CSV...");
            service.importarCSV(new InputStreamReader(file.getInputStream()));
            logger.info("CSV importado correctamente");
            return "CSV importado correctamente";
        } catch (Exception e) {
            logger.error("Error al importar CSV", e);
            return "Error al importar CSV";
        }
    }

    @PostMapping
    public String crearPerfil(@RequestBody PerfilDTO dto) {
        logger.info("Creando perfil...");
        service.crearPerfil(dto);
        logger.info("Perfil creado");
        return "Perfil creado";
    }

    @GetMapping
    public List<Perfil> obtenerTodos() {
        logger.info("Obteniendo todos los perfiles");
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Perfil obtenerPorId(@PathVariable int id) {
        logger.info("Obteniendo perfil con id {}", id);
        return service.obtenerPorId(id);
    }

     @PostMapping("/{id}/imagen")
    public String subirImagen(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            service.guardarImagen(id, file);
            return "Imagen subida correctamente";
        } catch (Exception e) {
            return "Error al subir imagen: " + e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String actualizarPerfil(@PathVariable int id, @RequestBody Perfil perfil) {
        service.actualizarPerfil(id, perfil);
        return "Perfil actualizado";
    }

    @DeleteMapping("/{id}")
    public String eliminarPerfil(@PathVariable int id) {
        service.eliminarPorId(id);
        return "Perfil eliminado";
    }

    @DeleteMapping
    public String eliminarTodos() {
        service.eliminarTodos();
        return "Todos los perfiles eliminados";
    }

   
}

