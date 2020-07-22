package com.perenco.controller.rol;

import com.perenco.dto.EtapaDTO;
import com.perenco.dto.RolDTO;
import com.perenco.service.etapa.EtapaServiceInterface;
import com.perenco.service.rol.RolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rol")
@CrossOrigin("*")
public class RolController {

    @Autowired
    private RolServiceInterface rolService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<RolDTO> users() {
        return rolService.roles();
    }

}
