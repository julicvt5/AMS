package com.perenco.service.sistema;

import com.perenco.dto.ProyectosDTO;
import com.perenco.dto.SistemaDTO;
import com.perenco.repository.etapas.EtapasEntity;
import com.perenco.repository.proyectos.ProyectosEntity;
import com.perenco.repository.proyectos.ProyectosRepository;
import com.perenco.repository.sistemas.SistemasEntity;
import com.perenco.repository.sistemas.SistemasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class SistemaServiceImpl implements SistemaServiceInterface {

    @Autowired
    private SistemasRepository sistemasRepository;

    private static final String ESTADO_ACTIVO = "1";

    @Override
    public List<SistemaDTO> sistemas() {

        List<SistemasEntity> sistemaEntities = sistemasRepository.findByEstado(ESTADO_ACTIVO);

        List<SistemaDTO> sistemaDTOS = new ArrayList<>();
        sistemaEntities.forEach( item -> {
            sistemaDTOS.add(SistemaDTO.builder()
                    .id(item.getId())
                    .nombreSistema(item.getNombre())
                    .NumeroSistema(item.getNumero())
                    .tipoSistema(item.getTipo())
                    .estado(item.getEstado())
                    .build());
        });

        return sistemaDTOS;
    }

    @Override
    public SistemaDTO save(SistemaDTO sistemaDTO) {
        SistemasEntity sistemasEntity = new SistemasEntity();

        sistemasEntity.setId(sistemaDTO.getId());
        sistemasEntity.setTipo(sistemaDTO.getTipoSistema());
        sistemasEntity.setNombre(sistemaDTO.getTipoSistema()+ " # " +sistemaDTO.getNumeroSistema());
        sistemasEntity.setFechaRegistro(new Date());
        sistemasEntity.setNumero(sistemaDTO.getNumeroSistema());
        sistemasEntity.setEstado(sistemaDTO.getEstado());

        SistemasEntity responseEntity = sistemasRepository.saveAndFlush(sistemasEntity);
        log.info(" Repsoen : {} ", responseEntity);

        sistemaDTO.setId(responseEntity.getId());
        return sistemaDTO;
    }

    @Override
    public SistemaDTO editar(SistemaDTO sistemaDTO) {
        log.info(" etapaDTO ::: {} ", sistemaDTO);
        Optional<SistemasEntity> entidad = sistemasRepository.findById(sistemaDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }
        SistemasEntity response = entidad.get();
        response.setNumero(sistemaDTO.getNumeroSistema());
        response.setTipo(sistemaDTO.getTipoSistema());
        response.setNombre(sistemaDTO.getTipoSistema()+ " # " +sistemaDTO.getNumeroSistema());
        response.setEstado(sistemaDTO.getEstado());

        sistemasRepository.saveAndFlush(response);

        return sistemaDTO;
    }
}
