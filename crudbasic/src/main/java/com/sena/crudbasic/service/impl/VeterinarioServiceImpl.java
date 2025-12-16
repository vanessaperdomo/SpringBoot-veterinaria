package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.VeterinarioRepository;
import com.sena.crudbasic.model.Veterinario;
import com.sena.crudbasic.dto.VeterinarioDto;
import com.sena.crudbasic.service.VeterinarioService;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repo;

    @Override
    public List<Veterinario> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Veterinario findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(VeterinarioDto veterinarioDto) {
        Veterinario veterinario = dtoToModel(veterinarioDto);
        repo.save(veterinario);
        return "Veterinario guardado exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return null;
    }

    @Override
    public List<Veterinario> filterByName(String nombre) {
        return repo.filterByName(nombre);
    }

    // Conversor DTO -> Model
    public Veterinario dtoToModel(VeterinarioDto veterinarioDto) {
        return new Veterinario(
                veterinarioDto.getId(),
                veterinarioDto.getNombre(),
                veterinarioDto.getTelefono(),
                veterinarioDto.getCorreo());
    }

    // Conversor Model -> DTO
    public VeterinarioDto modelToDto(Veterinario veterinario) {
        return new VeterinarioDto(
                veterinario.getId(),
                veterinario.getNombre(),
                veterinario.getTelefono(),
                veterinario.getCorreo());
    }
}
