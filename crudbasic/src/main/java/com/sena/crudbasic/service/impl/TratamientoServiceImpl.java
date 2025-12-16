package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.TratamientoRepository;
import com.sena.crudbasic.repository.DiagnosticoRepository;
import com.sena.crudbasic.model.Tratamiento;
import com.sena.crudbasic.model.Diagnostico;
import com.sena.crudbasic.dto.TratamientoDto;
import com.sena.crudbasic.service.TratamientoService;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository repo;

    @Autowired
    private DiagnosticoRepository diagnosticoRepo;

    @Override
    public List<Tratamiento> findAll() {
        return repo.findAll();
    }

    @Override
    public Tratamiento findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(TratamientoDto tratamientoDto) {
        Tratamiento tratamiento = dtoToModel(tratamientoDto);
        repo.save(tratamiento);
        return "Tratamiento guardado exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Tratamiento eliminado correctamente";
    }

    @Override
    public List<Tratamiento> filterByNombre(String nombre) {
        return repo.filterByNombre(nombre);
    }

    // 🔄 Conversor DTO -> Model
    public Tratamiento dtoToModel(TratamientoDto tratamientoDto) {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(tratamientoDto.getId());
        tratamiento.setNombre(tratamientoDto.getNombre());
        tratamiento.setDuracionDias(tratamientoDto.getDuracionDias());

        // Relacionar Diagnóstico
        if (tratamientoDto.getDiagnosticoId() != 0) {
            Diagnostico diagnostico = diagnosticoRepo.findById(tratamientoDto.getDiagnosticoId()).orElse(null);
            tratamiento.setDiagnostico(diagnostico);
        }

        return tratamiento;
    }

    // 🔄 Conversor Model -> DTO
    public TratamientoDto modelToDto(Tratamiento tratamiento) {
        TratamientoDto dto = new TratamientoDto();
        dto.setId(tratamiento.getId());
        dto.setNombre(tratamiento.getNombre());
        dto.setDuracionDias(tratamiento.getDuracionDias());

        if (tratamiento.getDiagnostico() != null) {
            dto.setDiagnosticoId(tratamiento.getDiagnostico().getId());
        }

        return dto;
    }
}
