package com.perenco.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SistemaDTO implements Serializable {

    private String id;
    private String tipoSistema;
    private String tipoSistemaId;
    private String NumeroSistema;
    private String nombreSistema;
    private String nombreUsuario;

}
