package com.perenco.repository.tbpozos;

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
@Table(name = "tb_pozos")
@ToString
public class PozosEntity implements Serializable {

    @Id
    private String id;

    private String nombre;

    private String ubicacion;

    @Column(name = "sistemas_nombre")
    private String sistemasNombre;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    private String estado;

}
