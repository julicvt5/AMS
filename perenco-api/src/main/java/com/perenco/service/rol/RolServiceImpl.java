package com.perenco.service.rol;

import com.perenco.dto.EstadoDTO;
import com.perenco.dto.RolDTO;
import com.perenco.repository.estados.EstadosEntity;
import com.perenco.repository.estados.EstadosRepository;
import com.perenco.repository.rol.RolEntity;
import com.perenco.repository.rol.RolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class RolServiceImpl implements RolServiceInterface {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolDTO> roles() {

        List<RolEntity> rolEntities = rolRepository.findAll();

        List<RolDTO> rolDTOS = new ArrayList<>();
        rolEntities.forEach( item -> {
            rolDTOS.add(RolDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .fechaRegistro(item.getFechaRegistro())
                    .build());
        });

        return rolDTOS;
    }
}
