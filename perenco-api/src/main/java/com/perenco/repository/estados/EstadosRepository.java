package com.perenco.repository.estados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadosRepository extends JpaRepository<EstadosEntity, String> {

    public List<EstadosEntity> findByEstado(final String estado);

}
