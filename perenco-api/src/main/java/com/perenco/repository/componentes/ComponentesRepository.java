package com.perenco.repository.componentes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentesRepository extends JpaRepository<ComponentesEntity, String> {

    public List<ComponentesEntity> findByEstado(final String estado);
}
