package com.sena.crudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crudbasic.repository.ServicioRepository;
import com.sena.crudbasic.model.Servicio;
import com.sena.crudbasic.dto.ServicioDto;
import com.sena.crudbasic.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository repo;

    @Override
    public List<Servicio> findAll() {
        return repo.findAll();
    }

    @Override
    public Servicio findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String save(ServicioDto servicioDto) {
        Servicio servicio = dtoToModel(servicioDto);
        repo.save(servicio);
        return "Servicio guardado exitosamente";
    }

    @Override
    public String delete(int id) {
        repo.deleteById(id);
        return "Servicio eliminado correctamente";
    }

    @Override
    public List<Servicio> filterByName(String nombre) {
        return repo.filterByName(nombre);
    }

    // 🔄 Conversor DTO -> Model
    public Servicio dtoToModel(ServicioDto servicioDto) {
        return new Servicio(
                servicioDto.getId(),
                servicioDto.getNombre(),
                servicioDto.getPrecio());
    }

    // 🔄 Conversor Model -> DTO
    public ServicioDto modelToDto(Servicio servicio) {
        return new ServicioDto(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getPrecio());
    }
}
