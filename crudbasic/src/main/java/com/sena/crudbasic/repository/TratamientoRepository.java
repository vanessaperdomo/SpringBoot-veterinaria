package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer> {

    @Query(""
            + "SELECT t "
            + "FROM tratamiento t "
            + "WHERE t.nombre LIKE %?1%")
    public List<Tratamiento> filterByNombre(String nombre);
}
