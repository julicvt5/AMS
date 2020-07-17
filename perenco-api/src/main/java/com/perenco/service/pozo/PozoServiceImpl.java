package com.perenco.service.pozo;

import com.perenco.dto.PozoDTO;
import com.perenco.repository.tbpozos.PozosEntity;
import com.perenco.repository.tbpozos.PozosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class PozoServiceImpl implements PozoServiceInterface {

    @Autowired
    private PozosRepository pozosRepository;


    @Override
    public List<PozoDTO> pozos() {

        List<PozosEntity> userEntities = pozosRepository.findAll();

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

}
