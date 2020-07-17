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
    private String nombre;
    private String email;
    private String rol;
    private Integer rolId;
    private String password;

}
