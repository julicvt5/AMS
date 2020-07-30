package com.perenco.service.moneda;

import com.perenco.dto.MonedaDTO;
import com.perenco.repository.monedas.MonedasEntity;
import com.perenco.repository.monedas.MonedasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class MonedaServiceImpl implements MonedaServiceInterface {

    @Autowired
    private MonedasRepository monedasRepository;

    @Override
    public List<MonedaDTO> monedas() {

        List<MonedasEntity> monedaEntities = monedasRepository.findAll();

        List<MonedaDTO> monedaDTOS = new ArrayList<>();

        monedaEntities.forEach( item -> {
            monedaDTOS.add(MonedaDTO.builder()
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .abreviatura(item.getAbreviatura())
                    .build());
        });

        return monedaDTOS;
    }
}
