package com.perenco.service.etapa;

import com.perenco.dto.EtapaDTO;

import java.util.List;

public interface EtapaServiceInterface {

    public List<EtapaDTO> etapas();

    public EtapaDTO guardar(final EtapaDTO etapaDTO);

    public EtapaDTO editar(final EtapaDTO etapaDTO);

}
