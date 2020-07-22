package com.perenco.service.componente;

import com.perenco.dto.ComponenteDTO;
import com.perenco.dto.EstadoDTO;

import java.util.List;

public interface ComponenteServiceInterface {

    public List<ComponenteDTO> componentes();

    public ComponenteDTO guardar(final ComponenteDTO componenteDTO);

    public ComponenteDTO editar(final ComponenteDTO componenteDTO);

}
