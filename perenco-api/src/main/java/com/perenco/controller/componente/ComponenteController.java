package com.perenco.controller.componente;

import com.perenco.dto.ComponenteDTO;
import com.perenco.dto.EstadoDTO;
import com.perenco.service.componente.ComponenteServiceInterface;
import com.perenco.service.estado.EstadoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/componente")
@CrossOrigin("*")
public class ComponenteController {

    @Autowired
    private ComponenteServiceInterface componenteService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<ComponenteDTO> componentes() {
        return componenteService.componentes();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public ComponenteDTO save(@RequestBody final ComponenteDTO componenteDTO) {
        return componenteService.guardar(componenteDTO);
    }

    @PostMapping( path = "/editar", consumes = "application/json", produces = "application/json")
    public ComponenteDTO editar(@RequestBody final ComponenteDTO componenteDTO) {
        return componenteService.editar(componenteDTO);
    }

}
