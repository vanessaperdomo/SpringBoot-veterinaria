package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.DiagnosticoDto;
import com.sena.crudbasic.model.Diagnostico;
import com.sena.crudbasic.service.DiagnosticoService;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService service;

    // 🔹 LISTAR TODOS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        List<Diagnostico> diagnosticos = service.findAll();
        return new ResponseEntity<>(diagnosticos, HttpStatus.OK);
    }

    // 🔹 GUARDAR
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody DiagnosticoDto d) {
        service.save(d);
        return new ResponseEntity<>("Diagnóstico guardado correctamente", HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Diagnostico diagnostico = service.findById(id);
        return new ResponseEntity<>(diagnostico, HttpStatus.OK);
    }

    // 🔹 FILTRAR POR DESCRIPCIÓN
    @GetMapping("filterbydescripcion/{descripcion}")
    public ResponseEntity<Object> filterByDescripcion(@PathVariable String descripcion) {
        List<Diagnostico> diagnosticos = service.filterByDescripcion(descripcion);
        return new ResponseEntity<>(diagnosticos, HttpStatus.OK);
    }

    // 🔹 ELIMINAR
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Diagnóstico eliminado", HttpStatus.OK);
    }
}
