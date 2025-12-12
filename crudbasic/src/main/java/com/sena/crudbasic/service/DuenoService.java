package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.Model.Dueno;
import com.sena.crudbasic.dto.DuenoDto;

public interface DuenoService {

    public List<Dueno> findAll();

    public Dueno findById(int id);

    public List<Dueno> filterByNombre(String nombre);

    public String save(DuenoDto d);

    public String delete(int id);
}
