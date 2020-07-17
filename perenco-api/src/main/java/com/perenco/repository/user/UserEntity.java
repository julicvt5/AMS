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
public class UserEntity   {


    @Column(name="iduser")
    private String idUser;

    private String nombre;

    private Integer rol;

    @Id
    @Column(name="email")
    private String email;

    private String password;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

}
