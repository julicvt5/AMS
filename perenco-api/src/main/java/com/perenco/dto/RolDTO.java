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
public class RolDTO implements Serializable {

    private String id;
    private String nombre;
    private Date fechaRegistro;
}
