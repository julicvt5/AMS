package com.perenco.repository.resumen;

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
public class ResumenEntity implements Serializable {

    @Id
    private String id;

    @Column(name = "nom_proyecto")
    private String nomProyecto;

    @Column(name = "nom_pozo")
    private String nomPozo;

    @Column(name = "nom_sistema")
    private String nomSistema;

    @Column(name = "nom_etapa")
    private String nomEtapa;

    @Column(name = "nom_componente")
    private String nomComponente;

    private String moneda;

    private Integer valor;

    @Column(name = "valor_moneda")
    private String valorMoneda;

    @Column(name = "nom_estado")
    private String nomEstado;

    @Column(name = "date_available")
    private Date dateAvailable;

    private Date comentarios;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "nom_usuario")
    private Date nomUsuario;

    @Column(name = "actualizado")
    private Date actualizado;

}
