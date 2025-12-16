package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.model.Diagnostico;
import com.sena.crudbasic.dto.DiagnosticoDto;

public interface DiagnosticoService {

    /*
     * findAll: buscar todos los diagnósticos
     * findById: buscar diagnóstico por id
     * filterByDescripcion: filtrar por descripción del diagnóstico
     * save: guardar
     * delete: eliminar
     */

    public List<Diagnostico> findAll();

    public Diagnostico findById(int id);

    public List<Diagnostico> filterByDescripcion(String descripcion);

    public String save(DiagnosticoDto d);

    public String delete(int id);
}
