package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.DuenoDto;
import com.sena.crudbasic.model.Dueno;
import com.sena.crudbasic.service.DuenoService;

@RestController
@RequestMapping("/duenos")
public class DuenoController {

    @Autowired
    private DuenoService service;

    // 🔹 LISTAR TODOS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<Object>(
                service.findAll(),
                HttpStatus.OK);
    }

    // 🔹 GUARDAR
    @PostMapping("")
    public ResponseEntity<Object> save(
            @RequestBody DuenoDto d) {
        service.save(d);
        return new ResponseEntity<Object>(
                "Dueño guardado correctamente",
                HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(
            @PathVariable int id) {
        Dueno dueno = service.findById(id);
        return new ResponseEntity<Object>(
                dueno,
                HttpStatus.OK);
    }

    // 🔹 FILTRAR POR NOMBRE
    @GetMapping("filterbyname/{nombre}")
    public ResponseEntity<Object> filterByName(
            @PathVariable String nombre) {
        List<Dueno> duenos = service.filterByName(nombre);
        return new ResponseEntity<Object>(
                duenos,
                HttpStatus.OK);
    }

    // 🔹 ELIMINAR
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(
            @PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<Object>(
                "Dueño eliminado",
                HttpStatus.OK);
    }
}
