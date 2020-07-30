package com.perenco.controller.moneda;

import com.perenco.dto.MonedaDTO;
import com.perenco.service.moneda.MonedaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/moneda")
@CrossOrigin("*")
public class MonedaController {

    @Autowired
    private MonedaServiceInterface monedaService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<MonedaDTO> users() {
        return monedaService.monedas();
    }


}
