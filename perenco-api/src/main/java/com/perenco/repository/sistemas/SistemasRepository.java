package com.perenco.repository.sistemas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemasRepository extends JpaRepository<SistemasEntity, String> {


}
