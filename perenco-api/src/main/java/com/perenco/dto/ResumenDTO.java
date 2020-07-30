package com.perenco.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResumenDTO {

    private String id;

    private String nomProyecto;

    private String nomPozo;

    private String nomSistema;

    private String nomEtapa;

    private String nomComponente;

    private String moneda;

    private Integer valor;

    private String valorMoneda;

    private String nomEstado;

    private Date dateAvailable;

    private Date comentarios;

    private Date fechaRegistro;

    private Date nomUsuario;

    private Date actualizado;
}
