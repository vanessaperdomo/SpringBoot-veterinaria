package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.CitaDto;
import com.sena.crudbasic.model.Cita;
import com.sena.crudbasic.service.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService service;

    // 🔹 LISTAR TODAS LAS CITAS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
                service.findAll(),
                HttpStatus.OK);
    }

    // 🔹 GUARDAR UNA CITA
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CitaDto c) {
        service.save(c);
        return new ResponseEntity<>(
                "Cita guardada correctamente",
                HttpStatus.OK);
    }

    // 🔹 BUSCAR CITA POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Cita cita = service.findById(id);
        return new ResponseEntity<>(
                cita,
                HttpStatus.OK);
    }

    // 🔹 FILTRAR POR MOTIVO
    @GetMapping("filterbymotivo/{motivo}")
    public ResponseEntity<Object> filterByMotivo(@PathVariable String motivo) {
        List<Cita> citas = service.filterByMotivo(motivo);
        return new ResponseEntity<>(
                citas,
                HttpStatus.OK);
    }

    // 🔹 ELIMINAR CITA POR ID
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(
                "Cita eliminada",
                HttpStatus.OK);
    }
}
