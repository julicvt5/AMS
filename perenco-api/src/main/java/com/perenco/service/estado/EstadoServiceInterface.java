package com.perenco.service.estado;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.EtapaDTO;

import java.util.List;

public interface EstadoServiceInterface {

    public List<EstadoDTO> estados();

    public EstadoDTO guardar(final EstadoDTO estadoDTO);

    public EstadoDTO editar(final EstadoDTO estadoDTO);

}
