package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.MascotaDto;
import com.sena.crudbasic.model.Mascota;
import com.sena.crudbasic.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService service;

    // 🔹 LISTAR TODAS LAS MASCOTAS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
                service.findAll(),
                HttpStatus.OK);
    }

    // 🔹 GUARDAR O ACTUALIZAR MASCOTA
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody MascotaDto m) {
        service.save(m);
        return new ResponseEntity<>(
                "Mascota guardada correctamente",
                HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Mascota mascota = service.findById(id);
        return new ResponseEntity<>(
                mascota,
                HttpStatus.OK);
    }

    // 🔹 FILTRAR POR NOMBRE
    @GetMapping("filterbyname/{nombre}")
    public ResponseEntity<Object> filterByName(@PathVariable String nombre) {
        List<Mascota> mascotas = service.filterByName(nombre);
        return new ResponseEntity<>(
                mascotas,
                HttpStatus.OK);
    }

    // 🔹 ELIMINAR POR ID
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(
                "Mascota eliminada correctamente",
                HttpStatus.OK);
    }
}
