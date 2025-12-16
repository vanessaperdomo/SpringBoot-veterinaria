package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.VeterinarioDto;
import com.sena.crudbasic.model.Veterinario;
import com.sena.crudbasic.service.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

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
            @RequestBody VeterinarioDto v) {
        service.save(v);
        return new ResponseEntity<Object>(
                "Veterinario guardado correctamente",
                HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(
            @PathVariable int id) {
        Veterinario veterinario = service.findById(id);
        return new ResponseEntity<Object>(
                veterinario,
                HttpStatus.OK);
    }

    // 🔹 FILTRAR POR NOMBRE
    @GetMapping("filterbyname/{nombre}")
    public ResponseEntity<Object> filterByName(
            @PathVariable String nombre) {
        List<Veterinario> veterinarios = service.filterByName(nombre);
        return new ResponseEntity<Object>(
                veterinarios,
                HttpStatus.OK);
    }

    // 🔹 ELIMINAR
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(
            @PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<Object>(
                "Veterinario eliminado",
                HttpStatus.OK);
    }
}
