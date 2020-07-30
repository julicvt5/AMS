package com.perenco.service.sistema;

import com.perenco.dto.EtapaDTO;
import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.SistemaDTO;

import java.util.List;

public interface SistemaServiceInterface {

    public List<SistemaDTO> sistemas();

    public SistemaDTO save(final SistemaDTO sistemaDTO);

    public SistemaDTO editar(final SistemaDTO sistemaDTO);


}
