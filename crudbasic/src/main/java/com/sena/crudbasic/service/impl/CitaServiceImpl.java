package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.CitaRepository;
import com.sena.crudbasic.model.Cita;
import com.sena.crudbasic.model.Mascota;
import com.sena.crudbasic.model.Veterinario;
import com.sena.crudbasic.dto.CitaDto;
import com.sena.crudbasic.service.CitaService;
import com.sena.crudbasic.repository.MascotaRepository;
import com.sena.crudbasic.repository.VeterinarioRepository;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository repo;

    @Autowired
    private MascotaRepository mascotaRepo;

    @Autowired
    private VeterinarioRepository veterinarioRepo;

    @Override
    public List<Cita> findAll() {
        return repo.findAll();
    }

    @Override
    public Cita findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(CitaDto citaDto) {
        Cita cita = dtoToModel(citaDto);
        repo.save(cita);
        return "Cita guardada exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Cita eliminada correctamente";
    }

    @Override
    public List<Cita> filterByMotivo(String motivo) {
        return repo.filterByMotivo(motivo);
    }

    // 🔄 Conversor DTO -> Model
    public Cita dtoToModel(CitaDto citaDto) {
        Cita cita = new Cita();
        cita.setId(citaDto.getId());
        cita.setFecha(citaDto.getFecha());
        cita.setHora(citaDto.getHora());
        cita.setMotivo(citaDto.getMotivo());

        // Relacionar Mascota
        if (citaDto.getMascotaId() != 0) {
            Mascota mascota = mascotaRepo.findById(citaDto.getMascotaId()).orElse(null);
            cita.setMascota(mascota);
        }

        // Relacionar Veterinario
        if (citaDto.getVeterinarioId() != 0) {
            Veterinario veterinario = veterinarioRepo.findById(citaDto.getVeterinarioId()).orElse(null);
            cita.setVeterinario(veterinario);
        }

        return cita;
    }

    // 🔄 Conversor Model -> DTO
    public CitaDto modelToDto(Cita cita) {
        CitaDto dto = new CitaDto();
        dto.setId(cita.getId());
        dto.setFecha(cita.getFecha());
        dto.setHora(cita.getHora());
        dto.setMotivo(cita.getMotivo());

        if (cita.getMascota() != null) {
            dto.setMascotaId(cita.getMascota().getId());
        }
        if (cita.getVeterinario() != null) {
            dto.setVeterinarioId(cita.getVeterinario().getId());
        }

        return dto;
    }
}
