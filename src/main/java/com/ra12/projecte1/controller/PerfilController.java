package com.ra12.projecte1.controller;

import com.ra12.projecte1.dto.PerfilDTO;
import com.ra12.projecte1.logging.CustomLogging;
import com.ra12.projecte1.model.Perfil;
import com.ra12.projecte1.service.PerfilService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @PostMapping("/csv")
    public String importarCSV(@RequestParam("file") MultipartFile file) {
        try {
            CustomLogging.info("PerfilController", "importarCSV", "Importando CSV...");
            service.importarCSV(new InputStreamReader(file.getInputStream()));
            CustomLogging.info("PerfilController", "importarCSV", "CSV importado correctamente");
            return "CSV importado correctamente";
        } catch (Exception e) {
            CustomLogging.error("PerfilController", "importarCSV", "Error al importar CSV: " + e.getMessage());
            return "Error al importar CSV";
        }
    }

    @PostMapping
    public String crearPerfil(@RequestBody PerfilDTO dto) {
        CustomLogging.info("PerfilController", "crearPerfil", "Creando perfil...");
        service.crearPerfil(dto);
        CustomLogging.info("PerfilController", "crearPerfil", "Perfil creado correctamente");
        return "Perfil creado";
    }

    @GetMapping
    public List<Perfil> obtenerTodos() {
        CustomLogging.info("PerfilController", "obtenerTodos", "Obteniendo todos los perfiles");
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Perfil obtenerPorId(@PathVariable int id) {
        CustomLogging.info("PerfilController", "obtenerPorId", "Obteniendo perfil con id=" + id);
        return service.obtenerPorId(id);
    }

    @PostMapping("/{id}/imagen")
    public String subirImagen(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            CustomLogging.info("PerfilController", "subirImagen", "Subiendo imagen para id=" + id);
            service.guardarImagen(id, file);
            CustomLogging.info("PerfilController", "subirImagen", "Imagen subida correctamente");
            return "Imagen subida correctamente";
        } catch (Exception e) {
            CustomLogging.error("PerfilController", "subirImagen", "Error al subir imagen: " + e.getMessage());
            return "Error al subir imagen: " + e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String actualizarPerfil(@PathVariable int id, @RequestBody Perfil perfil) {
        CustomLogging.info("PerfilController", "actualizarPerfil", "Actualizando perfil id=" + id);
        service.actualizarPerfil(id, perfil);
        CustomLogging.info("PerfilController", "actualizarPerfil", "Perfil actualizado correctamente");
        return "Perfil actualizado";
    }

    @DeleteMapping("/{id}")
    public String eliminarPerfil(@PathVariable int id) {
        CustomLogging.info("PerfilController", "eliminarPerfil", "Eliminando perfil id=" + id);
        service.eliminarPorId(id);
        CustomLogging.info("PerfilController", "eliminarPerfil", "Perfil eliminado correctamente");
        return "Perfil eliminado";
    }

    @DeleteMapping
    public String eliminarTodos() {
        CustomLogging.info("PerfilController", "eliminarTodos", "Eliminando todos los perfiles");
        service.eliminarTodos();
        CustomLogging.info("PerfilController", "eliminarTodos", "Todos los perfiles eliminados");
        return "Todos los perfiles eliminados";
    }
}
