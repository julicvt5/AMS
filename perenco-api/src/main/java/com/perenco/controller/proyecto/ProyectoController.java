package com.perenco.controller.proyecto;

import com.perenco.dto.ComponenteDTO;
import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.proyectos.ProyectosServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/proyecto")
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

    @PostMapping( path = "/pdf", consumes = "application/json", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> generarPdf(@RequestBody final ProyectosDTO proyectosDTO) {

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=proyecto-report.pdf");

        ByteArrayInputStream response = proyectosServiceInterface.generarPdf(proyectosDTO);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(response));
    }

}
