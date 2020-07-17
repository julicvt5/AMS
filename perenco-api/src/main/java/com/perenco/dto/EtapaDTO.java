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
public class EtapaDTO implements Serializable {

    private String id;
    private String nombreEtapa;
    private Date fechaRegistro;
    private String nombreUsuario;

}
