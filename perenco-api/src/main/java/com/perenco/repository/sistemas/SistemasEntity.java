package com.perenco.repository.sistemas;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sistemas")
@ToString
public class SistemasEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    private String tipo;

    private String numero;

    private String nombre;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    private String estado;
}
