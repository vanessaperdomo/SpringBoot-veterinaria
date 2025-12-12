package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.dto.VeterinarioDto;
import com.sena.crudbasic.Model.Veterinario;

public interface VeterinarioService {

    /*
     * findAll
     * findById
     * filterByName
     * save
     * delete
     */

    public List<Veterinario> findAll();

    public Veterinario findById(int id);

    public List<Veterinario> filterByName(String nombre);

    public String save(VeterinarioDto v);

    public String delete(int id);
}
