package com.perenco.repository.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@ToString
public class UserEntity implements Serializable  {

    @Id
    @Column(name="iduser")
    private String idUser;

    private String nombre;

    private String rol;

    private String email;

    private String password;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

}
