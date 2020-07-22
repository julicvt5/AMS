package com.perenco.service.user;

import com.perenco.dto.UserDTO;
import com.perenco.repository.rol.RolEntity;
import com.perenco.repository.rol.RolRepository;
import com.perenco.repository.tblogin.TbLoginRepository;
import com.perenco.repository.user.UserEntity;
import com.perenco.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private TbLoginRepository tbLoginRepository;

    private static final String ESTADO_ACTIVO = "1";


    @Override
    public List<UserDTO> usuarios() {

        List<UserEntity> userEntities = userRepository.findByEstado(ESTADO_ACTIVO);
        List<RolEntity> roles = rolRepository.findAll();

        List<UserDTO> userDTOS = new ArrayList<>();
        userEntities.forEach( item -> {
            userDTOS.add(UserDTO.builder()
                    .id(item.getId())
                    .idUser(item.getIdUser())
                    .nombre(item.getNombre())
                    .email(item.getEmail())
                    .rolId(item.getRol())
                    .rol(obtenerNombreRol(roles, item.getRol()))
                    .build());
        });

        return userDTOS;
    }

    @Override
    public UserDTO guardar(UserDTO userDTO) {
        /*RolEntity rol = new RolEntity();
        rol.setId("6");
        rol.setNombre("nombre 2");
        rol.setFechaRegistro(new Date());

        RolEntity rols = rolRepository.save(rol);
        rolRepository.flush();
        log.info("value :  {} ", rols);*/

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setIdUser(userDTO.getIdUser());
        userEntity.setNombre(userDTO.getNombre());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRol(userDTO.getRolId());
        userEntity.setFechaRegistro(new Date());
        userEntity.setEstado(ESTADO_ACTIVO);

        UserEntity userEntityResponse = userRepository.saveAndFlush(userEntity);
        log.info("value :  {} ", userEntityResponse);

        userDTO.setId(userEntityResponse.getId());
        /*TbLoginEntity entity = new TbLoginEntity();
        entity.setIdTbLogin("24");
        entity.setEmail("tetst@gmail.com");
        entity.setFecha( new Date());
        TbLoginEntity response = tbLoginRepository.save(entity);
        log.info(" Response ::: {} ", response);*/

        return userDTO;
    }

    @Override
    public UserDTO editar(UserDTO userDTO) {

        Optional<UserEntity> userEntityOptional = userRepository.findById(userDTO.getId());

        if (!userEntityOptional.isPresent()) {
            throw new RuntimeException("No se pudo actualizar");
        }

        final UserEntity userEntity = userEntityOptional.get();

        userEntity.setRol(validarRolId(userDTO, userEntity));
        userEntity.setNombre(userDTO.getNombre());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setEstado(userDTO.getEstado());

        userRepository.saveAndFlush(userEntity);

        return userDTO;
    }

    private String obtenerNombreRol( final List<RolEntity> roles, final String rolId) {
        String nombreRol = "";

        for ( RolEntity rolEntity: roles) {
          if (rolEntity.getId().equalsIgnoreCase(rolId.toString()) ){
              nombreRol = rolEntity.getNombre();
              break;
          }

        }
        return nombreRol;
    }

    private String validarRolId(UserDTO userDTO, final UserEntity userEntity) {
        if (Objects.nonNull(userDTO.getRolId()) && StringUtils.isNotEmpty(userDTO.getRolId())) {
            return userDTO.getRolId();
        }
        return userEntity.getRol();
    }

}
