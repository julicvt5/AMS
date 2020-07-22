package com.perenco.repository.tbpozos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PozosRepository extends JpaRepository<PozosEntity, String> {


}
