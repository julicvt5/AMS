package com.perenco.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProyectosDTO implements Serializable {

    private String id;
    private String nombre;
    private String descripcion;
    private String pozo;
    private String sistemas;
    private String fechaInicial;
    private String fechaEstimadaFin;
    private String fechaRealEntrega;
    private String nombreSistemas;
    private Date fechaRegistro;
    private String nombreUsuario;

}
