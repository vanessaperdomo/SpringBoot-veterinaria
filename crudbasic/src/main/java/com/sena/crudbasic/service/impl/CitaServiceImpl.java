package com.sena.crudbasic.service.impl;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.Model.Cita;
import com.sena.crudbasic.Model.Mascota;
import com.sena.crudbasic.Model.Veterinario;
import com.sena.crudbasic.dto.CitaDto;
import com.sena.crudbasic.repository.CitaRepository;
import com.sena.crudbasic.repository.MascotaRepository;
import com.sena.crudbasic.repository.VeterinarioRepository;
import com.sena.crudbasic.service.CitaService;

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
    public List<Cita> filterByFecha(String fecha) {
        return repo.filterByFecha(fecha);
    }

    public Cita dtoToModel(CitaDto c) {
        Mascota mascota = mascotaRepo.findById(c.getId_mascota()).orElse(null);
        Veterinario veterinario = veterinarioRepo.findById(c.getId_veterinario()).orElse(null);

        LocalDate fecha = LocalDate.parse(c.getFecha());
        LocalTime hora = LocalTime.parse(c.getHora());

        return new Cita(
                c.getId(),
                fecha,
                hora,
                c.getMotivo(),
                mascota,
                veterinario);
    }

    public Cita modelToDto(Cita c) {
        return new Cita(
                c.getId(),
                c.getFecha(),
                c.getHora(),
                c.getMotivo(),
                c.getMascota(),
                c.getVeterinario());
    }

    @Override
    public String save(CitaDto c) {
        Cita cita = dtoToModel(c);
        repo.save(cita);
        return "Cita guardada correctamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Cita eliminada correctamente";
    }
}
