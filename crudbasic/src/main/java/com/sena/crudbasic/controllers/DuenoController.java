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

import com.sena.crudbasic.Model.Dueno;
import com.sena.crudbasic.dto.DuenoDto;
import com.sena.crudbasic.service.DuenoService;

@RestController
@RequestMapping("/duenos")
public class DuenoController {

    @Autowired
    private DuenoService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<Object>(
                service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody DuenoDto d) {
        service.save(d);
        return new ResponseEntity<Object>(
                "Se guardó exitosamente", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Dueno dueno = service.findById(id);
        return new ResponseEntity<Object>(
                dueno, HttpStatus.OK);
    }

    @GetMapping("filterbyname/{nombre}")
    public ResponseEntity<Object> filterByName(@PathVariable String nombre) {
        List<Dueno> duenos = service.filterByNombre(nombre);
        return new ResponseEntity<Object>(
                duenos, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<Object>(
                "Se eliminó correctamente", HttpStatus.OK);
    }
}
