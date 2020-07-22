package com.perenco.repository.etapas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapasRepository extends JpaRepository<EtapasEntity, String> {


}
