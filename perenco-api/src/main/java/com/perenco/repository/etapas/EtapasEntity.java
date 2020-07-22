package com.perenco.repository.etapas;

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
@Table(name = "etapas")
@ToString
public class EtapasEntity implements Serializable {

    @Id
    private String id;

    @Column(name = "nom_etapa")
    private String nombreEtapa;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "nom_usuario")
    private String nomUsuario;

    private String estado;
}
