package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.MedicamentoRepository;
import com.sena.crudbasic.model.Medicamento;
import com.sena.crudbasic.dto.MedicamentoDto;
import com.sena.crudbasic.service.MedicamentoService;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository repo;

    @Override
    public List<Medicamento> findAll() {
        return repo.findAll();
    }

    @Override
    public Medicamento findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(MedicamentoDto medicamentoDto) {
        Medicamento medicamento = dtoToModel(medicamentoDto);
        repo.save(medicamento);
        return "Medicamento guardado exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Medicamento eliminado correctamente";
    }

    @Override
    public List<Medicamento> filterByNombre(String nombre) {
        return repo.filterByNombre(nombre);
    }

    // 🔄 Conversor DTO -> Model
    public Medicamento dtoToModel(MedicamentoDto dto) {
        Medicamento medicamento = new Medicamento();
        medicamento.setId(dto.getId());
        medicamento.setNombre(dto.getNombre());
        medicamento.setDosis(dto.getDosis());
        return medicamento;
    }

    // 🔄 Conversor Model -> DTO
    public MedicamentoDto modelToDto(Medicamento medicamento) {
        MedicamentoDto dto = new MedicamentoDto();
        dto.setId(medicamento.getId());
        dto.setNombre(medicamento.getNombre());
        dto.setDosis(medicamento.getDosis());
        return dto;
    }
}
