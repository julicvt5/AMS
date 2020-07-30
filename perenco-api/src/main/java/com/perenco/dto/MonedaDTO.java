package com.perenco.dto;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonedaDTO {

    private String id;
    private String abreviatura;
    private String nombre;
}
