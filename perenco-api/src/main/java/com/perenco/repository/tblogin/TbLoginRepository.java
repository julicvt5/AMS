package com.perenco.repository.tblogin;

import com.perenco.repository.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TbLoginRepository extends JpaRepository<TbLoginEntity, String> {


}
