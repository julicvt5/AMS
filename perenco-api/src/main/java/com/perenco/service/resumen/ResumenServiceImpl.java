package com.perenco.service.resumen;

import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.ResumenDTO;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import com.perenco.repository.resumen.ResumenEntity;
import com.perenco.repository.resumen.ResumenRepository;
import com.perenco.service.proyectos.ProyectosServiceInterface;
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
public class ResumenServiceImpl implements ResumenServiceInterface {

    @Autowired
    private ResumenRepository resumenRepository;

    private static final String ESTADO_ACTIVO = "1";

    @Override
    public ResumenDTO guardar(ResumenDTO resumenDTO) {
        ResumenEntity resumenEntity = new ResumenEntity();

        resumenEntity.setId("0");
        resumenEntity.setFechaRegistro(new Date());

        ResumenEntity response = resumenRepository.saveAndFlush(resumenEntity);

        resumenDTO.setId(response.getId());

        return resumenDTO;
    }

}
