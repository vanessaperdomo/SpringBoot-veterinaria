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
import com.sena.crudbasic.Model.Veterinario;
import com.sena.crudbasic.service.VeterinarioService;
import com.sena.crudbasic.dto.VeterinarioDto;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    // Obtener todos los veterinarios
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<Object>(service.findAll(), HttpStatus.OK);
    }

    // Guardar un nuevo veterinario
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody VeterinarioDto v) {
        service.save(v);
        return new ResponseEntity<Object>("Se guardó correctamente", HttpStatus.OK);
    }

    // Obtener veterinario por ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Veterinario veterinario = service.findById(id);
        return new ResponseEntity<Object>(veterinario, HttpStatus.OK);
    }

    // Filtrar veterinarios por nombre (opcional, ejemplo)
    @GetMapping("filterbyname/{nombre}")
    public ResponseEntity<Object> filterByName(@PathVariable String nombre) {
        List<Veterinario> veterinarios = service.filterByName(nombre);
        return new ResponseEntity<Object>(veterinarios, HttpStatus.OK);
    }

    // Eliminar veterinario por ID
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<Object>("Se eliminó correctamente", HttpStatus.OK);
    }
}
