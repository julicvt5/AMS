package com.perenco.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public Optional<UserEntity> findByEmailAndPassword(final String email, final String password);

    public UserEntity save(final UserEntity userEntity);

    public List<UserEntity> findByEstado(final String estado);

}
