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

import com.sena.crudbasic.Model.Cita;
import com.sena.crudbasic.dto.CitaDto;
import com.sena.crudbasic.service.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<Object>(
                service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CitaDto c) {
        service.save(c);
        return new ResponseEntity<Object>(
                "Cita guardada correctamente", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Cita cita = service.findById(id);
        return new ResponseEntity<Object>(
                cita, HttpStatus.OK);
    }

    @GetMapping("filterbyfecha/{fecha}")
    public ResponseEntity<Object> filterByFecha(@PathVariable String fecha) {
        List<Cita> citas = service.filterByFecha(fecha);
        return new ResponseEntity<Object>(
                citas, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<Object>(
                "Cita eliminada correctamente", HttpStatus.OK);
    }
}
