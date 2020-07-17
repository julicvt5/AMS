package com.perenco.controller.sistema;

import com.perenco.dto.SistemaDTO;
import com.perenco.service.sistema.SistemaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaController {

    @Autowired
    private SistemaServiceInterface sistemaService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<SistemaDTO> pozos() {
        return sistemaService.sistemas();
    }

}
