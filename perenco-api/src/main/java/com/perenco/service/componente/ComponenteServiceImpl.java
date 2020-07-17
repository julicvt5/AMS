package com.perenco.service.componente;

import com.perenco.dto.ComponenteDTO;
import com.perenco.dto.EstadoDTO;
import com.perenco.repository.componentes.ComponentesEntity;
import com.perenco.repository.componentes.ComponentesRepository;
import com.perenco.repository.estados.EstadosEntity;
import com.perenco.repository.estados.EstadosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ComponenteServiceImpl implements ComponenteServiceInterface {

    @Autowired
    private ComponentesRepository componentesRepository;

    @Override
    public List<ComponenteDTO> componentes() {

        List<ComponentesEntity> proyectoEntities = componentesRepository.findAll();

        List<ComponenteDTO> componenteDTOS = new ArrayList<>();
        proyectoEntities.forEach( item -> {
            componenteDTOS.add(ComponenteDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .nombre(item.getNombre())
                    .nombreEtapa(item.getNomEtapa())
                    .fechaRegistro(item.getFechaRegistro())
                    .build());
        });

        return componenteDTOS;
    }
}
