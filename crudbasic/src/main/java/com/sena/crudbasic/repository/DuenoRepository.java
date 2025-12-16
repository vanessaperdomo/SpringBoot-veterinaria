package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Dueno;

@Repository
public interface DuenoRepository
        extends JpaRepository<Dueno, Integer> {

    @Query(""
            + "SELECT "
            + "d "
            + "FROM "
            + "dueno d "
            + "WHERE "
            + "d.nombre LIKE %?1%")
    public List<Dueno> filterByName(String nombre);
}
