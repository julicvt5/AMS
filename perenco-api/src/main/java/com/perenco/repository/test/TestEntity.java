package com.perenco.repository.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test") // Nombre de la tabla en BD
public class TestEntity {

    @Id
    @Column(name = "Id")
    private String id;

    private String nombre;

}
