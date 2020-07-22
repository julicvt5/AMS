package com.perenco.repository.monedas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedasRepository extends JpaRepository<MonedasEntity, String> {


}
