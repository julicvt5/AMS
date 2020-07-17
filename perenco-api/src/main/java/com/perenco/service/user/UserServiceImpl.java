package com.perenco.service.user;

import com.perenco.dto.LoginDTO;
import com.perenco.dto.UserDTO;
import com.perenco.repository.rol.RolEntity;
import com.perenco.repository.rol.RolRepository;
import com.perenco.repository.tblogin.TbLoginEntity;
import com.perenco.repository.tblogin.TbLoginRepository;
import com.perenco.repository.user.UserEntity;
import com.perenco.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private TbLoginRepository tbLoginRepository;


    @Override
    public List<UserDTO> usuarios() {

        List<UserEntity> userEntities = userRepository.findAll();
        List<RolEntity> roles = rolRepository.findAll();

        List<UserDTO> userDTOS = new ArrayList<>();
        userEntities.forEach( item -> {
            userDTOS.add(UserDTO.builder()
                    .id(item.getIdUser())
                    .nombre(item.getNombre())
                    .email(item.getEmail())
                    .rolId(item.getRol())
                    .rol(obtenerNombreRol(roles, item.getRol()))
                    .build());
        });

        return userDTOS;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        /*RolEntity rol = new RolEntity();
        rol.setId("6");
        rol.setNombre("nombre 2");
        rol.setFechaRegistro(new Date());

        RolEntity rols = rolRepository.save(rol);
        rolRepository.flush();
        log.info("value :  {} ", rols);*/

        /*UserEntity userEntity = new UserEntity();
        userEntity.setIdUser("15642");
        userEntity.setNombre("Test");
        userEntity.setEmail("tets@gmail.com");
        userEntity.setPassword("asdfsdfsdafasdf");
        userEntity.setRol(1);
        userEntity.setFechaRegistro(new Date());

        UserEntity userEntity2 = userRepository.save(userEntity);
        log.info("value :  {} ", userEntity2);*/


        TbLoginEntity entity = new TbLoginEntity();
        entity.setIdTbLogin("24");
        entity.setEmail("tetst@gmail.com");
        entity.setFecha( new Date());
        TbLoginEntity response = tbLoginRepository.save(entity);
        log.info(" Response ::: {} ", response);

        return userDTO;
    }

    private String obtenerNombreRol( final List<RolEntity> roles, final Integer rolId) {
        String nombreRol = "";

        for ( RolEntity rolEntity: roles) {
          if (rolEntity.getId().equalsIgnoreCase(rolId.toString()) ){
              nombreRol = rolEntity.getNombre();
              break;
          }

        }
        return nombreRol;
    }

}
