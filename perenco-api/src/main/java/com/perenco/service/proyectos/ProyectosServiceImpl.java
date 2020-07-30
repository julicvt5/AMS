package com.perenco.service.proyectos;

import com.perenco.dto.ProyectosDTO;
import com.perenco.repository.etapas.EtapasEntity;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import com.perenco.utils.GenerarProyectoPdfReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class ProyectosServiceImpl implements ProyectosServiceInterface {

    @Autowired
    private ProyectosRepository proyectosRepository;


    private static final String ESTADO_ACTIVO = "1";
    @Override
    public List<ProyectosDTO> proyectos() {

        List<ProyectosEntity> proyectoEntities = proyectosRepository.findByEstado(ESTADO_ACTIVO);

        log.info(" proyectoEntities : {} ", proyectoEntities);

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

    @Override
    public ProyectosDTO guardar(ProyectosDTO proyectosDTO) {
        ProyectosEntity proyectoEntity = new ProyectosEntity();

        proyectoEntity.setId("0");
        proyectoEntity.setNombre(proyectosDTO.getNombre());
        proyectoEntity.setNomUsuario(proyectosDTO.getNombreUsuario());
        proyectoEntity.setDescripcion(proyectosDTO.getDescripcion());
        proyectoEntity.setNomPozo(proyectosDTO.getPozo());
        proyectoEntity.setNomSistema(proyectosDTO.getSistemas());
        proyectoEntity.setFechaInicio(proyectosDTO.getFechaInicial());
        proyectoEntity.setFechaEstimadaFin(proyectosDTO.getFechaEstimadaFin());
        proyectoEntity.setFechaRealFin(proyectosDTO.getFechaRealEntrega());
        proyectoEntity.setFechaRegistro(new Date());
        proyectoEntity.setEstado(proyectosDTO.getEstado());

        ProyectosEntity response = proyectosRepository.saveAndFlush(proyectoEntity);

        proyectosDTO.setId(response.getId());

        return proyectosDTO;
    }

    @Override
    public ProyectosDTO editar(ProyectosDTO proyectosDTO) {
        log.info(" proyectosDTO ::: {} ", proyectosDTO);
        Optional<ProyectosEntity> entidad = proyectosRepository.findById(proyectosDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }

        ProyectosEntity response = entidad.get();
        response.setDescripcion(proyectosDTO.getDescripcion());
        response.setFechaInicio(proyectosDTO.getFechaInicial());
        response.setFechaEstimadaFin(proyectosDTO.getFechaEstimadaFin());
        response.setFechaRealFin(proyectosDTO.getFechaRealEntrega());
        response.setEstado(proyectosDTO.getEstado());

        proyectosRepository.saveAndFlush(response);

        return proyectosDTO;
    }

    @Override
    public ByteArrayInputStream generarPdf(ProyectosDTO proyectosDTO) {

        log.info(" proyectosDTO ::: {} ", proyectosDTO);
        Optional<ProyectosEntity> entidad = proyectosRepository.findById(proyectosDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }
        ProyectosEntity responseEntity = entidad.get();

        ProyectosDTO proyecto = new ProyectosDTO();

        proyecto.setId(responseEntity.getId());
        proyecto.setDescripcion(responseEntity.getDescripcion());
        proyecto.setNombre(responseEntity.getNombre());
        proyecto.setPozo(responseEntity.getNomPozo());
        proyecto.setSistemas(responseEntity.getNomSistema());
        proyecto.setFechaInicial(responseEntity.getFechaInicio());
        proyecto.setFechaEstimadaFin(responseEntity.getFechaEstimadaFin());
        proyecto.setFechaRealEntrega(responseEntity.getFechaRealFin());

        GenerarProyectoPdfReport generarPdfFile = new GenerarProyectoPdfReport();

        return generarPdfFile.proyectoReport(proyecto);
    }
}
