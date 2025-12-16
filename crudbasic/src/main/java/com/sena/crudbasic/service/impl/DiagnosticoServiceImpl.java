package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.model.Diagnostico;
import com.sena.crudbasic.model.Cita;
import com.sena.crudbasic.dto.DiagnosticoDto;
import com.sena.crudbasic.repository.DiagnosticoRepository;
import com.sena.crudbasic.repository.CitaRepository;
import com.sena.crudbasic.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoRepository repo;

    @Autowired
    private CitaRepository citaRepo;

    @Override
    public List<Diagnostico> findAll() {
        return repo.findAll();
    }

    @Override
    public Diagnostico findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(DiagnosticoDto diagnosticoDto) {
        Diagnostico diagnostico = dtoToModel(diagnosticoDto);
        repo.save(diagnostico);
        return "Diagnóstico guardado exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Diagnóstico eliminado correctamente";
    }

    @Override
    public List<Diagnostico> filterByDescripcion(String descripcion) {
        return repo.filterByDescripcion(descripcion);
    }

    // 🔄 Conversor DTO -> Model
    public Diagnostico dtoToModel(DiagnosticoDto diagnosticoDto) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(diagnosticoDto.getId());
        diagnostico.setDescripcion(diagnosticoDto.getDescripcion());

        // Relacionar Cita
        if (diagnosticoDto.getCitaId() != 0) {
            Cita cita = citaRepo.findById(diagnosticoDto.getCitaId()).orElse(null);
            diagnostico.setCita(cita);
        }

        return diagnostico;
    }

    // 🔄 Conversor Model -> DTO
    public DiagnosticoDto modelToDto(Diagnostico diagnostico) {
        DiagnosticoDto dto = new DiagnosticoDto();
        dto.setId(diagnostico.getId());
        dto.setDescripcion(diagnostico.getDescripcion());

        if (diagnostico.getCita() != null) {
            dto.setCitaId(diagnostico.getCita().getId());
        }

        return dto;
    }
}
