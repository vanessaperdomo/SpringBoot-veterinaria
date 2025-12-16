package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.DuenoRepository;
import com.sena.crudbasic.model.Dueno;
import com.sena.crudbasic.dto.DuenoDto;
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
    public String save(DuenoDto duenoDto) {
        Dueno dueno = dtoToModel(duenoDto);
        repo.save(dueno);
        return "Dueño guardado exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Dueño eliminado correctamente";
    }

    @Override
    public List<Dueno> filterByName(String nombre) {
        return repo.filterByName(nombre);
    }

    // 🔄 Conversor DTO -> Model
    public Dueno dtoToModel(DuenoDto duenoDto) {
        return new Dueno(
                duenoDto.getId(),
                duenoDto.getNombre(),
                duenoDto.getTelefono(),
                duenoDto.getDireccion());
    }

    // 🔄 Conversor Model -> DTO
    public DuenoDto modelToDto(Dueno dueno) {
        return new DuenoDto(
                dueno.getId(),
                dueno.getNombre(),
                dueno.getTelefono(),
                dueno.getDireccion());
    }
}
