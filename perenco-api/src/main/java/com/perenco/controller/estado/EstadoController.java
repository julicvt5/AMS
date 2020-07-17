package com.perenco.controller.estado;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.estado.EstadoServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {

    @Autowired
    private EstadoServiceInterface estadoService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<EstadoDTO> users() {
        return estadoService.estados();
    }

}
