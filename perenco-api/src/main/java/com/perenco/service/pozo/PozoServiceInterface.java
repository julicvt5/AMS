package com.perenco.service.pozo;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.PozoDTO;
import com.perenco.dto.UserDTO;

import java.util.List;

public interface PozoServiceInterface {

    public List<PozoDTO> pozos();

    public PozoDTO guardar(final PozoDTO pozoDTO);

    public PozoDTO editar(final PozoDTO pozoDTO);

}
