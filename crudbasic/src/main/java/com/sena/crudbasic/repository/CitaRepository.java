package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.Model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    @Query(""
            + "SELECT "
            + "c "
            + "FROM "
            + "cita c "
            + "WHERE "
            + "CAST(c.fecha AS string) LIKE %?1%")
    public List<Cita> filterByFecha(String fecha);
}
