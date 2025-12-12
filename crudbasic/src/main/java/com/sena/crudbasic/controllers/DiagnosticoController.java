package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crudbasic.Model.Diagnostico;
import com.sena.crudbasic.dto.DiagnosticoDto;
import com.sena.crudbasic.service.DiagnosticoService;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<Object>(
                service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody DiagnosticoDto d) {
        service.save(d);
        return new ResponseEntity<Object>(
                "Diagnóstico guardado correctamente", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Diagnostico diagnostico = service.findById(id);
        return new ResponseEntity<Object>(
                diagnostico, HttpStatus.OK);
    }

    @GetMapping("filterbydescripcion/{descripcion}")
    public ResponseEntity<Object> filterByDescripcion(@PathVariable String descripcion) {
        List<Diagnostico> diagnosticos = service.filterByDescripcion(descripcion);
        return new ResponseEntity<Object>(
                diagnosticos, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<Object>(
                "Diagnóstico eliminado correctamente", HttpStatus.OK);
    }
}
