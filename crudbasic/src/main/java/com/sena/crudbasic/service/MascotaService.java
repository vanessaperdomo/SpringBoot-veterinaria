package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.Model.Mascota;
import com.sena.crudbasic.dto.MascotaDto;

public interface MascotaService {

    public List<Mascota> findAll();

    public Mascota findById(int id);

    public List<Mascota> filterByNombre(String nombre);

    public String save(MascotaDto m);

    public String delete(int id);
}
