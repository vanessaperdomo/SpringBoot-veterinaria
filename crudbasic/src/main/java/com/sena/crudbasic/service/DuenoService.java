package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.model.Dueno;
import com.sena.crudbasic.dto.DuenoDto;

public interface DuenoService {

    /*
     * findAll: buscar todos los dueños
     * findById: buscar dueño por id
     * filterByName: filtrar por nombre del dueño
     * save: guardar
     * delete: eliminar
     */

    public List<Dueno> findAll();

    public Dueno findById(int id);

    public List<Dueno> filterByName(String nombre);

    public String save(DuenoDto d);

    public String delete(int id);
}
