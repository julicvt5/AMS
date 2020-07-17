package com.perenco.service.sistema;

import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.SistemaDTO;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import com.perenco.repository.sistemas.SistemasEntity;
import com.perenco.repository.sistemas.SistemasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class SistemaServiceImpl implements SistemaServiceInterface {

    @Autowired
    private SistemasRepository sistemasRepository;

    @Override
    public List<SistemaDTO> sistemas() {

        List<SistemasEntity> sistemaEntities = sistemasRepository.findAll();

        List<SistemaDTO> sistemaDTOS = new ArrayList<>();
        sistemaEntities.forEach( item -> {
            sistemaDTOS.add(SistemaDTO.builder()
                    .id(item.getId())
                    .nombreSistema(item.getNombre())
                    .NumeroSistema(item.getNumero())
                    .tipoSistema(item.getTipo())
                    .build());
        });

        return sistemaDTOS;
    }
}
