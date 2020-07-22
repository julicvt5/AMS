package com.perenco.controller.estado;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.EtapaDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.estado.EstadoServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estado")
@CrossOrigin("*")
public class EstadoController {

    @Autowired
    private EstadoServiceInterface estadoService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<EstadoDTO> users() {
        return estadoService.estados();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public EstadoDTO save(@RequestBody final EstadoDTO estadoDTO) {
        return estadoService.guardar(estadoDTO);
    }

    @PostMapping( path = "/editar", consumes = "application/json", produces = "application/json")
    public EstadoDTO editar(@RequestBody final EstadoDTO estadoDTO) {
        return estadoService.editar(estadoDTO);
    }

}
