package com.perenco.repository.etapas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtapasRepository extends JpaRepository<EtapasEntity, String> {

    public List<EtapasEntity> findByEstado(final String estado);
}
