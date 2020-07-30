package com.perenco.service.proyectos;

import com.perenco.dto.ProyectosDTO;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ProyectosServiceInterface {

    public List<ProyectosDTO> proyectos();

    public ProyectosDTO guardar(final ProyectosDTO proyectosDTO);

    public ProyectosDTO editar(final ProyectosDTO proyectosDTO);

    public ByteArrayInputStream generarPdf(final ProyectosDTO proyectosDTO);

}
