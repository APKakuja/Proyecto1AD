package com.ra12.projecte1.service;

import com.ra12.projecte1.dto.PerfilDTO;
import com.ra12.projecte1.model.Perfil;
import com.ra12.projecte1.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class PerfilService {

    private final PerfilRepository repository;

    public PerfilService(PerfilRepository repository) {
        this.repository = repository;
    }

    public void crearPerfil(PerfilDTO dto) {
        Perfil p = new Perfil();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setProfesion(dto.getProfesion());
        p.setSkills(dto.getSkills());
        p.setExperiencia(dto.getExperiencia());
        p.setLocalizacion(dto.getLocalizacion());
        p.setFoto(null); // la parte de imagen la hará tu compañera

        repository.save(p);
    }

    public List<Perfil> obtenerTodos() {
        return repository.findAll();
    }

    public Perfil obtenerPorId(int id) {
        return repository.findById(id);
    }

    public void importarCSV(InputStreamReader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String linea;

        br.readLine();

        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");

            if (campos.length < 6) {
                continue;
            }

            PerfilDTO dto = new PerfilDTO();
            dto.setNombre(campos[0]);
            dto.setDescripcion(campos[1]);
            dto.setProfesion(campos[2]);
            dto.setSkills(campos[3]);
            dto.setExperiencia(Integer.parseInt(campos[4]));
            dto.setLocalizacion(campos[5]);

            crearPerfil(dto);
        }
    }
}
