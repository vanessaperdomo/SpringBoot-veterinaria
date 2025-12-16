package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.model.Tratamiento;
import com.sena.crudbasic.dto.TratamientoDto;

public interface TratamientoService {

    /*
     * findAll: buscar todos los tratamientos
     * findById: buscar tratamiento por id
     * filterByNombre: filtrar por nombre del tratamiento
     * save: guardar
     * delete: eliminar
     */

    public List<Tratamiento> findAll();

    public Tratamiento findById(int id);

    public List<Tratamiento> filterByNombre(String nombre);

    public String save(TratamientoDto t);

    public String delete(int id);
}
