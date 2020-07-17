package com.perenco.controller.proyecto;

import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.proyectos.ProyectosServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectosServiceInterface proyectosServiceInterface;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<ProyectosDTO> users() {
        return proyectosServiceInterface.proyectos();
    }

}
