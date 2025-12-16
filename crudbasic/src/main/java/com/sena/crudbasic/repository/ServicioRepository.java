package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(""
            + "SELECT s "
            + "FROM servicio s "
            + "WHERE s.nombre LIKE %?1%")
    public List<Servicio> filterByName(String nombre);
}
