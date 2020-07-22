package com.perenco.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode()
public class UserDTO implements Serializable {

    private String id;
    private String idUser;
    private String nombre;
    private String email;
    private String rol;
    private String rolId;
    private String password;
    private String estado;

}
