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
import java.util.Date;
import java.util.List;
import java.util.UUID;


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

    @Override
    public SistemaDTO save(SistemaDTO sistemaDTO) {
        SistemasEntity sistemasEntity = new SistemasEntity();

        sistemasEntity.setId(sistemaDTO.getId());
        sistemasEntity.setTipo(sistemaDTO.getTipoSistema());
        sistemasEntity.setNombre(sistemaDTO.getNombreSistema());
        sistemasEntity.setFechaRegistro(new Date());
        sistemasEntity.setNumero(sistemaDTO.getNumeroSistema());

        SistemasEntity responseEntity = sistemasRepository.saveAndFlush(sistemasEntity);
        log.info(" Repsoen : {} ", responseEntity);

        sistemaDTO.setId(responseEntity.getId());
        return sistemaDTO;
    }
}
