package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.model.Medicamento;
import com.sena.crudbasic.dto.MedicamentoDto;

public interface MedicamentoService {

    /*
     * findAll: buscar todos los medicamentos
     * findById: buscar medicamento por id
     * filterByNombre: filtrar por nombre del medicamento
     * save: guardar
     * delete: eliminar
     */

    public List<Medicamento> findAll();

    public Medicamento findById(int id);

    public List<Medicamento> filterByNombre(String nombre);

    public String save(MedicamentoDto m);

    public String delete(int id);
}
