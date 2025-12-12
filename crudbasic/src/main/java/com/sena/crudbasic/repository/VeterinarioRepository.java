package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sena.crudbasic.Model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

    @Query(""
            + "SELECT v "
            + "FROM veterinario v "
            + "WHERE v.nombre like %?1%")
    public List<Veterinario> filterByName(String nombre);
}
