package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.Model.Cita;
import com.sena.crudbasic.dto.CitaDto;

public interface CitaService {

    public List<Cita> findAll();

    public Cita findById(int id);

    public List<Cita> filterByFecha(String fecha);

    public String save(CitaDto c);

    public String delete(int id);
}
