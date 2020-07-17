package com.perenco.controller.componente;

import com.perenco.dto.ComponenteDTO;
import com.perenco.dto.EstadoDTO;
import com.perenco.service.componente.ComponenteServiceInterface;
import com.perenco.service.estado.EstadoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/componente")
public class ComponenteController {

    @Autowired
    private ComponenteServiceInterface componenteService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<ComponenteDTO> users() {
        return componenteService.componentes();
    }

}
