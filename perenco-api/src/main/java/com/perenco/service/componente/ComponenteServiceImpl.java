package com.perenco.service.componente;

import com.perenco.dto.ComponenteDTO;
import com.perenco.repository.componentes.ComponentesEntity;
import com.perenco.repository.componentes.ComponentesRepository;
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
public class ComponenteServiceImpl implements ComponenteServiceInterface {

    @Autowired
    private ComponentesRepository componentesRepository;

    @Autowired
    private EtapasRepository etapasRepository;

    private static final String ESTADO_ACTIVO = "1";

    @Override
    public List<ComponenteDTO> componentes() {

        List<ComponentesEntity> proyectoEntities = componentesRepository.findByEstado(ESTADO_ACTIVO);

        List<EtapasEntity> etapaList = etapasRepository.findAll();

        List<ComponenteDTO> componenteDTOS = new ArrayList<>();

        proyectoEntities.forEach( item -> {
            componenteDTOS.add(ComponenteDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .nombre(item.getNombre())
                    .nombreEtapa(obtenerNombreEtapas(etapaList, item.getNomEtapa()))
                    .fechaRegistro(item.getFechaRegistro())
                    .estado(item.getEstado())
                    .build());
        });

        return componenteDTOS;
    }

    @Override
    public ComponenteDTO guardar(ComponenteDTO componenteDTO) {
        ComponentesEntity componenenteEntity = new ComponentesEntity();
        componenenteEntity.setId("0");
        componenenteEntity.setNombre(componenteDTO.getNombre());
        componenenteEntity.setNomUsuario(componenteDTO.getNombreUsuario());
        componenenteEntity.setNomEtapa(componenteDTO.getNombreEtapa());
        componenenteEntity.setFechaRegistro(new Date());
        componenenteEntity.setEstado(componenteDTO.getEstado());

        ComponentesEntity response = componentesRepository.saveAndFlush(componenenteEntity);

        componenteDTO.setId(response.getId());

        return componenteDTO;
    }

    @Override
    public ComponenteDTO editar(ComponenteDTO componenteDTO) {
        log.info(" componenteDTO ::: {} ", componenteDTO);
        Optional<ComponentesEntity> entidad = componentesRepository.findById(componenteDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }

        ComponentesEntity response = entidad.get();
        response.setNombre(componenteDTO.getNombre());
        response.setEstado(componenteDTO.getEstado());

        componentesRepository.saveAndFlush(response);

        return componenteDTO;
    }

    private String obtenerNombreEtapas(final List<EtapasEntity> etapas, final String etapaId) {
        String nombreEtapa = "";

        for ( EtapasEntity etapasEntity: etapas) {
            if (etapasEntity.getId().equalsIgnoreCase(etapaId.toString()) ){
                nombreEtapa = etapasEntity.getNombreEtapa();
                break;
            }
        }
        return nombreEtapa;
    }
}
