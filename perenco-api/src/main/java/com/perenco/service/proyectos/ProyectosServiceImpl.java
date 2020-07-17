package com.perenco.service.proyectos;

import com.perenco.dto.ProyectosDTO;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ProyectosServiceImpl implements ProyectosServiceInterface {

    @Autowired
    private ProyectosRepository proyectosRepository;

    @Override
    public List<ProyectosDTO> proyectos() {

        List<ProyectosEntity> proyectoEntities = proyectosRepository.findAll();

        List<ProyectosDTO> proyectoDTOS = new ArrayList<>();
        proyectoEntities.forEach( item -> {
            proyectoDTOS.add(ProyectosDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .descripcion(item.getDescripcion())
                    .pozo(item.getNomPozo())
                    .sistemas(item.getNomSistema())
                    .fechaInicial(item.getFechaInicio())
                    .fechaEstimadaFin(item.getFechaEstimadaFin())
                    .fechaRealEntrega(item.getFechaRealFin())
                    .nombreSistemas(item.getNomSistema())
                    .fechaRegistro(item.getFechaRegistro())
                    .nombreUsuario(item.getNomUsuario())
                    .build());
        });

        return proyectoDTOS;
    }
}
