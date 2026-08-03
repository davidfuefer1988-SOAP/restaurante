package com.david.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {

    @GetMapping("/categorias")
    public String categorias() {
        return "categorias";
    }

}
