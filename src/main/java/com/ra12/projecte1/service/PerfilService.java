package com.ra12.projecte1.service;

import com.ra12.projecte1.dto.PerfilDTO;
import com.ra12.projecte1.logging.CustomLogging;
import com.ra12.projecte1.model.Perfil;
import com.ra12.projecte1.repository.PerfilRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PerfilService {

    private final PerfilRepository repository;
    private final String uploadDir = "uploads/";

    public PerfilService(PerfilRepository repository) {
        this.repository = repository;
    }

    public void crearPerfil(PerfilDTO dto) {
        CustomLogging.info("PerfilService", "crearPerfil", "Creando nuevo perfil");

        Perfil p = new Perfil();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setGenero(dto.getGenero());
        p.setPuesto(dto.getPuesto());
        p.setSkills(dto.getSkills());
        p.setExperiencia(dto.getExperiencia());
        p.setLocalizacion(dto.getLocalizacion());
        p.setEdad(dto.getEdad());
        p.setFotoUrl(dto.getFotoUrl());
        p.setCreatedAt(LocalDateTime.now());

        repository.save(p);

        CustomLogging.info("PerfilService", "crearPerfil", "Perfil creado correctamente");
    }

    public List<Perfil> obtenerTodos() {
        CustomLogging.info("PerfilService", "obtenerTodos", "Obteniendo todos los perfiles");
        return repository.findAll();
    }

    public Perfil obtenerPorId(int id) {
        CustomLogging.info("PerfilService", "obtenerPorId", "Buscando perfil con id=" + id);
        return repository.findById(id);
    }

    public void importarCSV(InputStreamReader reader) throws Exception {
        CustomLogging.info("PerfilService", "importarCSV", "Inicio importación CSV");

        BufferedReader br = new BufferedReader(reader);
        String linea;

        br.readLine(); 

        int count = 0;

        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");

            if (campos.length < 8) {
                CustomLogging.error("PerfilService", "importarCSV", "Línea inválida: " + linea);
                continue;
            }

            PerfilDTO dto = new PerfilDTO();
            dto.setNombre(campos[0]);
            dto.setDescripcion(campos[1]);
            dto.setGenero(campos[2]);
            dto.setPuesto(campos[3]);
            dto.setSkills(campos[4]);
            dto.setExperiencia(Integer.parseInt(campos[5]));
            dto.setLocalizacion(campos[6]);
            dto.setEdad(Integer.parseInt(campos[7]));

            crearPerfil(dto);
            count++;
        }

        CustomLogging.info("PerfilService", "importarCSV", "CSV importado. Registros=" + count);
    }

    public void actualizarPerfil(int id, Perfil perfil) {
        CustomLogging.info("PerfilService", "actualizarPerfil", "Actualizando perfil id=" + id);
        perfil.setCreatedAt(LocalDateTime.now());
        repository.actualizarPerfil(id, perfil);
    }

    public void eliminarPorId(int id) {
        CustomLogging.info("PerfilService", "eliminarPorId", "Eliminando perfil id=" + id);
        repository.eliminarPorId(id);
    }

    public void eliminarTodos() {
        CustomLogging.info("PerfilService", "eliminarTodos", "Eliminando todos los perfiles");
        repository.eliminarTodos();
    }

    public void guardarImagen(int id, MultipartFile file) throws IOException {
        String rutaUpload = System.getProperty("user.dir") + "/uploads/";
        File carpeta = new File(rutaUpload);
        if (!carpeta.exists()) {
            carpeta.mkdirs(); 
        }   

        String nombreArchivo = id + "_" + file.getOriginalFilename().replaceAll(" ", "_");
        File destino = new File(rutaUpload + nombreArchivo);
        file.transferTo(destino);

        repository.guardarImagen(id, nombreArchivo);
    }
}