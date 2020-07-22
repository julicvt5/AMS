package com.perenco.controller.etapa;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.EtapaDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.estado.EstadoServiceInterface;
import com.perenco.service.etapa.EtapaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/etapa")
@CrossOrigin("*")
public class EtapaController {

    @Autowired
    private EtapaServiceInterface etapaService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<EtapaDTO> users() {
        return etapaService.etapas();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public EtapaDTO save(@RequestBody final EtapaDTO etapaDTO) {
        return etapaService.guardar(etapaDTO);
    }

    @PostMapping( path = "/editar", consumes = "application/json", produces = "application/json")
    public EtapaDTO editar(@RequestBody final EtapaDTO etapaDTO) {
        return etapaService.editar(etapaDTO);
    }

}
