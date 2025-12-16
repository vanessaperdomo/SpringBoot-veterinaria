package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.ServicioDto;
import com.sena.crudbasic.model.Servicio;
import com.sena.crudbasic.service.ServicioService;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService service;

    // 🔹 LISTAR TODOS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
                service.findAll(),
                HttpStatus.OK);
    }

    // 🔹 GUARDAR
    @PostMapping("")
    public ResponseEntity<Object> save(
            @RequestBody ServicioDto s) {
        service.save(s);
        return new ResponseEntity<>(
                "Servicio guardado correctamente",
                HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(
            @PathVariable int id) {
        Servicio servicio = service.findById(id);
        return new ResponseEntity<>(
                servicio,
                HttpStatus.OK);
    }

    // 🔹 FILTRAR POR NOMBRE
    @GetMapping("filterbyname/{nombre}")
    public ResponseEntity<Object> filterByName(
            @PathVariable String nombre) {
        List<Servicio> servicios = service.filterByName(nombre);
        return new ResponseEntity<>(
                servicios,
                HttpStatus.OK);
    }

    // 🔹 ELIMINAR
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(
            @PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(
                "Servicio eliminado",
                HttpStatus.OK);
    }
}
