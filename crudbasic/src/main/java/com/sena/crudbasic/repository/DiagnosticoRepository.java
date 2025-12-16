package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Diagnostico;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

    @Query(""
            + "SELECT d "
            + "FROM diagnostico d "
            + "WHERE d.descripcion LIKE %?1%")
    public List<Diagnostico> filterByDescripcion(String descripcion);
}
