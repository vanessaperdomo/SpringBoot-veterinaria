package com.sena.crudbasic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sena.crudbasic.models.Dueno;

import org.springframework.ui.Model;

@Controller
public class MascotaController {

    @GetMapping("/detalles_info")

    public String info(Model model) {
        Dueno dueno1 = new Dueno(1, "Camilo Penagos", "555-1234", "Calle Falsa 123");

        model.addAttribute("dueno", dueno1);

        return "detalles_info";
    }
}