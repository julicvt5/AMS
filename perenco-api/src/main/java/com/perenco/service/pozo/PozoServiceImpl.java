package com.perenco.service.pozo;

import com.perenco.dto.PozoDTO;
import com.perenco.repository.etapas.EtapasEntity;
import com.perenco.repository.tbpozos.PozosEntity;
import com.perenco.repository.tbpozos.PozosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class PozoServiceImpl implements PozoServiceInterface {

    @Autowired
    private PozosRepository pozosRepository;


    @Override
    public List<PozoDTO> pozos() {

        List<PozosEntity> userEntities = pozosRepository.findAll();
        log.info(" INFO POZOS : {} ", userEntities);
        List<PozoDTO> pozoDTOS = new ArrayList<>();
        userEntities.forEach( item -> {
            pozoDTOS.add(PozoDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .ubicacion(item.getUbicacion())
                    .sistema(item.getSistemasNombre())
                    .build());
        });

        return pozoDTOS;
    }

    @Override
    public PozoDTO guardar(PozoDTO pozoDTO) {

        PozosEntity pozoEntity = new PozosEntity();
        pozoEntity.setId("0");
        pozoEntity.setNombre(pozoDTO.getNombre());
        pozoEntity.setUbicacion(pozoDTO.getUbicacion());
        pozoEntity.setSistemasNombre(pozoDTO.getSistema());
        pozoEntity.setNombreUsuario(pozoDTO.getUsuario());
        pozoEntity.setFechaRegistro(new Date());
        pozoEntity.setEstado(pozoDTO.getEstado());

        PozosEntity response = pozosRepository.saveAndFlush(pozoEntity);

        pozoDTO.setId(response.getId());

        return pozoDTO;
    }

    @Override
    public PozoDTO editar(PozoDTO pozoDTO) {
        log.info(" etapaDTO ::: {} ", pozoDTO);
        Optional<PozosEntity> entidad = pozosRepository.findById(pozoDTO.getId());

        if (!entidad.isPresent()) {
            throw new RuntimeException("Registro no encontrado");
        }
        PozosEntity response = entidad.get();
        response.setNombre(pozoDTO.getNombre());
        response.setUbicacion(pozoDTO.getUbicacion());
        response.setEstado(pozoDTO.getEstado());

        pozosRepository.saveAndFlush(response);

        return pozoDTO;
    }

}
