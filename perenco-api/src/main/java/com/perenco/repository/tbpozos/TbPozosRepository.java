package com.perenco.repository.tbpozos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TbPozosRepository extends JpaRepository<TbPozosEntity, String> {


}
