package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.model.Veterinario;
import com.sena.crudbasic.dto.VeterinarioDto;

public interface VeterinarioService {

    /*
     * findAll: buscar todos los veterinarios
     * findById: buscar veterinario por id
     * filterByName: filtrar por nombre del veterinario
     * save: guardar
     * delete: eliminar
     */

    public List<Veterinario> findAll();

    public Veterinario findById(int id);

    public List<Veterinario> filterByName(String nombre);

    public String save(VeterinarioDto v);

    public String delete(int id);
}
