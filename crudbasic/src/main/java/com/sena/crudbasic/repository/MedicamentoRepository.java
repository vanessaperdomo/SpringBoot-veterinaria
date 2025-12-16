package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

    @Query(""
            + "SELECT m "
            + "FROM medicamento m "
            + "WHERE m.nombre LIKE %?1%")
    public List<Medicamento> filterByNombre(String nombre);
}
