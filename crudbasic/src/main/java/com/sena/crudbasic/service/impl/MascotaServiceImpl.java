package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.MascotaRepository;
import com.sena.crudbasic.repository.DuenoRepository;
import com.sena.crudbasic.model.Dueno;
import com.sena.crudbasic.model.Mascota;
import com.sena.crudbasic.dto.MascotaDto;
import com.sena.crudbasic.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository repo;

    @Autowired
    private DuenoRepository duenoRepo;

    @Override
    public List<Mascota> findAll() {
        return repo.findAll();
    }

    @Override
    public Mascota findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(MascotaDto mascotaDto) {
        Mascota mascota = dtoToModel(mascotaDto);
        if (mascota.getDueno() == null && mascotaDto.getDuenoId() != 0) {
            return "Error: No existe un dueño con id " + mascotaDto.getDuenoId();
        }
        repo.save(mascota);
        return "Mascota guardada exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Mascota eliminada correctamente";
    }

    @Override
    public List<Mascota> filterByName(String nombre) {
        return repo.filterByName(nombre);
    }

    // 🔄 Conversor DTO -> Model
    public Mascota dtoToModel(MascotaDto mascotaDto) {
        Mascota mascota = new Mascota();
        mascota.setId(mascotaDto.getId());
        mascota.setNombre(mascotaDto.getNombre());
        mascota.setEspecie(mascotaDto.getEspecie());
        mascota.setRaza(mascotaDto.getRaza());
        mascota.setEdad(mascotaDto.getEdad());

        // Asignar dueño existente
        if (mascotaDto.getDuenoId() != 0) {
            Dueno dueno = duenoRepo.findById(mascotaDto.getDuenoId()).orElse(null);
            mascota.setDueno(dueno);
        }

        return mascota;
    }

    // 🔄 Conversor Model -> DTO
    public MascotaDto modelToDto(Mascota mascota) {
        MascotaDto dto = new MascotaDto();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setRaza(mascota.getRaza());
        dto.setEdad(mascota.getEdad());

        if (mascota.getDueno() != null) {
            dto.setDuenoId(mascota.getDueno().getId());
        }

        return dto;
    }
}
