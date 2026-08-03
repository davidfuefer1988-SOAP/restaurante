package com.david.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MesaController {

    @GetMapping("/mesas")
    public String mesas() {
        return "mesas";
    }

}