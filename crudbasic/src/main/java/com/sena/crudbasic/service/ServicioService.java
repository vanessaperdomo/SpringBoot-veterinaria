package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.model.Servicio;
import com.sena.crudbasic.dto.ServicioDto;

public interface ServicioService {

    /*
     * findAll: buscar todos los servicios
     * findById: buscar servicio por id
     * filterByName: filtrar por nombre del servicio
     * save: guardar
     * delete: eliminar
     */

    public List<Servicio> findAll();

    public Servicio findById(int id);

    public List<Servicio> filterByName(String nombre);

    public String save(ServicioDto s);

    public String delete(int id);
}
