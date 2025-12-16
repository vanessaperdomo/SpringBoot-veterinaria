package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    @Query(""
            + "SELECT c "
            + "FROM cita c "
            + "WHERE c.motivo LIKE %?1%")
    public List<Cita> filterByMotivo(String motivo);
}
