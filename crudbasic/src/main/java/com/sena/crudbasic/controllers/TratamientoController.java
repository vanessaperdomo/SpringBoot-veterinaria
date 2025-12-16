package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.TratamientoDto;
import com.sena.crudbasic.model.Tratamiento;
import com.sena.crudbasic.service.TratamientoService;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {

    @Autowired
    private TratamientoService service;

    // 🔹 LISTAR TODOS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
                service.findAll(),
                HttpStatus.OK);
    }

    // 🔹 GUARDAR
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody TratamientoDto t) {
        service.save(t);
        return new ResponseEntity<>(
                "Tratamiento guardado correctamente",
                HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Tratamiento tratamiento = service.findById(id);
        return new ResponseEntity<>(
                tratamiento,
                HttpStatus.OK);
    }

    // 🔹 FILTRAR POR NOMBRE
    @GetMapping("filterbynombre/{nombre}")
    public ResponseEntity<Object> filterByNombre(@PathVariable String nombre) {
        List<Tratamiento> tratamientos = service.filterByNombre(nombre);
        return new ResponseEntity<>(
                tratamientos,
                HttpStatus.OK);
    }

    // 🔹 ELIMINAR
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(
                "Tratamiento eliminado correctamente",
                HttpStatus.OK);
    }
}
