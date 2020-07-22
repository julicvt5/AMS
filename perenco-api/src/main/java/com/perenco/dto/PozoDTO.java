package com.perenco.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PozoDTO implements Serializable {

    private String id;
    private String nombre;
    private String ubicacion;
    private String sistema;
    private String usuario;
    private String estado;

}
