package com.perenco.repository.tbpozos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PozosRepository extends JpaRepository<PozosEntity, String> {

    public List<PozosEntity> findByEstado(final String estado);
}
