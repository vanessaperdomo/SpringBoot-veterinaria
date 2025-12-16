package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.model.Cita;
import com.sena.crudbasic.dto.CitaDto;

public interface CitaService {

    /*
     * findAll: buscar todas las citas
     * findById: buscar cita por id
     * filterByMotivo: filtrar por motivo de la cita
     * save: guardar
     * delete: eliminar
     */

    public List<Cita> findAll();

    public Cita findById(int id);

    public List<Cita> filterByMotivo(String motivo);

    public String save(CitaDto c);

    public String delete(int id);
}
