package com.sena.crudbasic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.crudbasic.models.dto.DuenoDto;

@RestController
@RequestMapping("/api")
public class MascotaRestController {

    @GetMapping(path = "/detalles_info2")
    public DuenoDto detalles_info2() {
        DuenoDto usuario1 = new DuenoDto();
        usuario1.setIdDueno(1);
        usuario1.setNombre("Laura Perez");
        return usuario1;
    }

}
