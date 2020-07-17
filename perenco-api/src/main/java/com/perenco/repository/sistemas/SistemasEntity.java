package com.perenco.repository.sistemas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "tblogin")
@ToString
public class SistemasEntity implements Serializable {

    @Id
    private String id;

    private String tipo;

    private Integer numero;

    private String nombre;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
