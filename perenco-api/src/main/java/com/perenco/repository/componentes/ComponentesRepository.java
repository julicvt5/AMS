package com.perenco.repository.componentes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentesRepository extends JpaRepository<ComponentesEntity, String> {


}
