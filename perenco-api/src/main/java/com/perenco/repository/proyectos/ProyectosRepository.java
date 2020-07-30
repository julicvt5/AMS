package com.perenco.repository.proyectos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectosRepository extends JpaRepository<ProyectosEntity, String> {

    public List<ProyectosEntity> findByEstado(final String estado);

}
