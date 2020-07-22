package com.perenco.service.estado;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.ProyectosDTO;
import com.perenco.repository.estados.EstadosEntity;
import com.perenco.repository.estados.EstadosRepository;
import com.perenco.repository.etapas.EtapasEntity;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
                    .nombreUsuario(item.getNomUsuario())
                    .fechaRegistro(item.getFechaRegistro())
                    .build());
        });

        return estadoDTOS;
    }

    @Override
    public EstadoDTO guardar(EstadoDTO estadoDTO) {
        EstadosEntity estadoEntity = new EstadosEntity();
        estadoEntity.setId("0");
        estadoEntity.setNombre(estadoDTO.getNombre());
        estadoEntity.setFechaRegistro(new Date());

        EstadosEntity response = estadosRepository.saveAndFlush(estadoEntity);

        estadoDTO.setId(response.getId());

        return estadoDTO;
    }

    @Override
    public EstadoDTO editar(EstadoDTO estadoDTO) {
        log.info(" etapaDTO ::: {} ", estadoDTO);
        Optional<EstadosEntity> entidad = estadosRepository.findById(estadoDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }
        EstadosEntity response = entidad.get();
        response.setNombre(estadoDTO.getNombre());
        response.setEstado(estadoDTO.getEstado());

        estadosRepository.saveAndFlush(response);

        return estadoDTO;
    }
}
