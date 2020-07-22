package com.perenco.service.etapa;

import com.perenco.dto.EtapaDTO;
import com.perenco.repository.etapas.EtapasEntity;
import com.perenco.repository.etapas.EtapasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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

    @Override
    public EtapaDTO guardar(EtapaDTO etapaDTO) {

        EtapasEntity etapasEntity = new EtapasEntity();
        etapasEntity.setId("0");
        etapasEntity.setNombreEtapa(etapaDTO.getNombreEtapa());
        etapasEntity.setNomUsuario(etapaDTO.getNombreUsuario());
        etapasEntity.setFechaRegistro(new Date());

        EtapasEntity response = etapasRepository.saveAndFlush(etapasEntity);

        etapaDTO.setId(response.getId());

        return etapaDTO;
    }

    @Override
    public EtapaDTO editar(EtapaDTO etapaDTO) {

        log.info(" etapaDTO ::: {} ", etapaDTO);
        Optional<EtapasEntity> entidad = etapasRepository.findById(etapaDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }
        EtapasEntity response = entidad.get();
        response.setNombreEtapa(etapaDTO.getNombreEtapa());
        response.setEstado(etapaDTO.getEstado());

        etapasRepository.saveAndFlush(response);
        
        return etapaDTO;
    }
}
