package com.perenco.controller.etapa;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.EtapaDTO;
import com.perenco.service.estado.EstadoServiceInterface;
import com.perenco.service.etapa.EtapaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/etapa")
public class EtapaController {

    @Autowired
    private EtapaServiceInterface etapaService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<EtapaDTO> users() {
        return etapaService.etapas();
    }

}
