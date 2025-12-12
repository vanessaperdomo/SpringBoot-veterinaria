package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.Model.Mascota;
import com.sena.crudbasic.Model.Dueno;
import com.sena.crudbasic.dto.MascotaDto;
import com.sena.crudbasic.repository.MascotaRepository;
import com.sena.crudbasic.repository.DuenoRepository;
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
    public List<Mascota> filterByNombre(String nombre) {
        return repo.filterByNombre(nombre);
    }

    public Mascota dtoToModel(MascotaDto m) {
        Dueno dueno = duenoRepo.findById(m.getDueno().getId()).orElse(null);

        return new Mascota(
                m.getId(),
                m.getNombre(),
                m.getEspecie(),
                m.getRaza(),
                m.getEdad(),
                dueno);
    }

    public Mascota modelToDto(Mascota m) {
        return new Mascota(
                m.getId(),
                m.getNombre(),
                m.getEspecie(),
                m.getRaza(),
                m.getEdad(),
                m.getDueno());
    }

    @Override
    public String save(MascotaDto m) {
        Mascota mascota = dtoToModel(m);
        repo.save(mascota);
        return "Mascota guardada correctamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Mascota eliminada correctamente";
    }
}
