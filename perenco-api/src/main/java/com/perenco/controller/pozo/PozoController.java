package com.perenco.controller.pozo;

import com.perenco.dto.EtapaDTO;
import com.perenco.dto.PozoDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.pozo.PozoServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pozo")
@CrossOrigin("*")
public class PozoController {

    @Autowired
    private PozoServiceInterface pozoService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<PozoDTO> pozos() {
        return pozoService.pozos();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public PozoDTO save(@RequestBody final PozoDTO pozoDTO) {
        return pozoService.guardar(pozoDTO);
    }

    @PostMapping( path = "/editar", consumes = "application/json", produces = "application/json")
    public PozoDTO editar(@RequestBody final PozoDTO pozoDTO) {
        return pozoService.editar(pozoDTO);
    }

}
