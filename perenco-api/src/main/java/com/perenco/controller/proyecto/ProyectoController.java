package com.perenco.controller.proyecto;

import com.perenco.dto.ComponenteDTO;
import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.proyectos.ProyectosServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/proyecto")
@CrossOrigin("*")
public class ProyectoController {

    @Autowired
    private ProyectosServiceInterface proyectosServiceInterface;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<ProyectosDTO> proyectos() {
        return proyectosServiceInterface.proyectos();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public ProyectosDTO save(@RequestBody final ProyectosDTO proyectosDTO) {
        return proyectosServiceInterface.guardar(proyectosDTO);
    }

    @PostMapping( path = "/editar", consumes = "application/json", produces = "application/json")
    public ProyectosDTO editar(@RequestBody final ProyectosDTO proyectosDTO) {
        return proyectosServiceInterface.editar(proyectosDTO);
    }

}
