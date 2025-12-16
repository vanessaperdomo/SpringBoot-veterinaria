package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    @Query(""
            + "SELECT m "
            + "FROM mascota m "
            + "WHERE m.nombre LIKE %?1%")
    public List<Mascota> filterByName(String nombre);
}
