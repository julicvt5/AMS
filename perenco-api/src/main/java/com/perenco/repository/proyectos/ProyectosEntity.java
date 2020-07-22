package com.perenco.repository.proyectos;

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
@Table(name = "proyectos")
@ToString
public class ProyectosEntity implements Serializable {

    @Id
    @Column(name="idProyectos")
    private String id;

    private String nombre;

    private String descripcion;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_estimada_fin")
    private String fechaEstimadaFin;

    @Column(name = "fecha_real_fin")
    private String fechaRealFin;

    @Column(name = "nom_pozo")
    private String nomPozo;

    @Column(name = "nom_sistema")
    private String nomSistema;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "nom_usuario")
    private String nomUsuario;

    private String estado;

}
