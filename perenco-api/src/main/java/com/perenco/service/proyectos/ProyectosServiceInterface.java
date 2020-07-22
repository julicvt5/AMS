package com.perenco.service.proyectos;

import com.perenco.dto.PozoDTO;
import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.UserDTO;

import java.util.List;

public interface ProyectosServiceInterface {

    public List<ProyectosDTO> proyectos();

    public ProyectosDTO guardar(final ProyectosDTO proyectosDTO);

    public ProyectosDTO editar(final ProyectosDTO proyectosDTO);

}
