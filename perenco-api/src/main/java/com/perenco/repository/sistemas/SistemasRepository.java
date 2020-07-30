package com.perenco.repository.sistemas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SistemasRepository extends JpaRepository<SistemasEntity, String> {

    public List<SistemasEntity> findByEstado(final String estado);
}
