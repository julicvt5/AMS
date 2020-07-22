package com.perenco.controller.sistema;

import com.perenco.dto.SistemaDTO;
import com.perenco.service.sistema.SistemaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sistema")
@CrossOrigin("*")
public class SistemaController {

    @Autowired
    private SistemaServiceInterface sistemaService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<SistemaDTO> pozos() {
        return sistemaService.sistemas();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public SistemaDTO save(@RequestBody final SistemaDTO sistemaDTO) {
        return sistemaService.save(sistemaDTO);
    }

}
