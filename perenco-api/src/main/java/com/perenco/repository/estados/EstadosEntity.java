package com.perenco.repository.estados;

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
@Table(name = "estados")
@ToString
public class EstadosEntity implements Serializable {

    @Id
    private String id;

    private String nombre;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    private String estado;

    @Column(name = "nom_usuario")
    private String nomUsuario;
}
