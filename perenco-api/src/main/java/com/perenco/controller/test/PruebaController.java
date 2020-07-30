package com.perenco.controller.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prueba")
@CrossOrigin("*")
public class PruebaController {

    @GetMapping
    public String prueba() {
        return "Hola persona ";
    }

}
