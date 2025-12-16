package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.model.Mascota;
import com.sena.crudbasic.dto.MascotaDto;

public interface MascotaService {

    /*
     * findAll: buscar todas las mascotas
     * findById: buscar mascota por id
     * filterByName: filtrar por nombre de la mascota
     * save: guardar
     * delete: eliminar
     */

    public List<Mascota> findAll();

    public Mascota findById(int id);

    public List<Mascota> filterByName(String nombre);

    public String save(MascotaDto m);

    public String delete(int id);
}
