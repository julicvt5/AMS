package com.perenco.repository.monedas;

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
@Table(name = "monedas")
@ToString
public class MonedasEntity implements Serializable {

    @Id
    private String id;

    private String abreviatura;

    private String nombre;
}
