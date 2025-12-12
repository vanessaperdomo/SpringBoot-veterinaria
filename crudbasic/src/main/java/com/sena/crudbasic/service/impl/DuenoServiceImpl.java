package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.Model.Dueno;
import com.sena.crudbasic.dto.DuenoDto;
import com.sena.crudbasic.repository.DuenoRepository;
import com.sena.crudbasic.service.DuenoService;

@Service
public class DuenoServiceImpl implements DuenoService {

    @Autowired
    private DuenoRepository repo;

    @Override
    public List<Dueno> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Dueno findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Dueno> filterByNombre(String nombre) {
        return repo.filterByNombre(nombre);
    }

    public Dueno dtoToModel(DuenoDto duenoDto) {
        return new Dueno(
                duenoDto.getId(),
                duenoDto.getNombre(),
                duenoDto.getTelefono(),
                duenoDto.getDireccion());
    }

    public Dueno modelToDto(Dueno dueno) {
        return new Dueno(
                dueno.getId(),
                dueno.getNombre(),
                dueno.getTelefono(),
                dueno.getDireccion());
    }

    @Override
    public String save(DuenoDto duenoDto) {
        Dueno dueno = dtoToModel(duenoDto);
        repo.save(dueno);
        return "Dueño guardado correctamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Dueño eliminado correctamente";
    }
}
