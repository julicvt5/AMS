package com.perenco.service.etapa;

import com.perenco.dto.EtapaDTO;
import com.perenco.repository.etapas.EtapasEntity;
import com.perenco.repository.etapas.EtapasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class EtapaServiceImpl implements EtapaServiceInterface {

    @Autowired
    private EtapasRepository etapasRepository;

    @Override
    public List<EtapaDTO> etapas() {
        List<EtapasEntity> etapaEntities = etapasRepository.findAll();
        List<EtapaDTO> etapaDTOS = new ArrayList<>();
        etapaEntities.forEach( item -> {
            etapaDTOS.add(EtapaDTO.builder()
                    .id(item.getId())
                    .nombreEtapa(item.getNombreEtapa())
                    .fechaRegistro(item.getFechaRegistro())
                    .nombreUsuario(item.getNomUsuario())
                    .build());
        });
        return etapaDTOS;
    }
}
