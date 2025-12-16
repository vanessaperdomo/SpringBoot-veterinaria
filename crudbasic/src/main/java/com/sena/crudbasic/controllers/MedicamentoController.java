package com.sena.crudbasic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.crudbasic.dto.MedicamentoDto;
import com.sena.crudbasic.model.Medicamento;
import com.sena.crudbasic.service.MedicamentoService;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService service;

    // 🔹 LISTAR TODOS
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        List<Medicamento> medicamentos = service.findAll();
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    // 🔹 GUARDAR
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody MedicamentoDto m) {
        service.save(m);
        return new ResponseEntity<>("Medicamento guardado correctamente", HttpStatus.OK);
    }

    // 🔹 BUSCAR POR ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Medicamento medicamento = service.findById(id);
        return new ResponseEntity<>(medicamento, HttpStatus.OK);
    }

    // 🔹 FILTRAR POR NOMBRE
    @GetMapping("filterbynombre/{nombre}")
    public ResponseEntity<Object> filterByNombre(@PathVariable String nombre) {
        List<Medicamento> medicamentos = service.filterByNombre(nombre);
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    // 🔹 ELIMINAR
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Medicamento eliminado correctamente", HttpStatus.OK);
    }
}
