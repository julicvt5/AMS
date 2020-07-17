package com.perenco.service.estado;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.ProyectosDTO;
import com.perenco.repository.estados.EstadosEntity;
import com.perenco.repository.estados.EstadosRepository;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class EstadoServiceImpl implements EstadoServiceInterface {

    @Autowired
    private EstadosRepository estadosRepository;

    @Override
    public List<EstadoDTO> estados() {

        List<EstadosEntity> proyectoEntities = estadosRepository.findAll();

        List<EstadoDTO> estadoDTOS = new ArrayList<>();
        proyectoEntities.forEach( item -> {
            estadoDTOS.add(EstadoDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .fechaRegistro(item.getFechaRegistro())
                    .build());
        });

        return estadoDTOS;
    }
}
