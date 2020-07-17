package com.perenco.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO implements Serializable {

    private String id;
    private String nombre;
    private String email;
    private String rol;
    private String rolId;

}
