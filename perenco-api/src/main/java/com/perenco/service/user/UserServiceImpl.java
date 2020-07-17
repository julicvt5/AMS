package com.perenco.service.user;

import com.perenco.dto.LoginDTO;
import com.perenco.dto.UserDTO;
import com.perenco.repository.rol.RolEntity;
import com.perenco.repository.rol.RolRepository;
import com.perenco.repository.user.UserEntity;
import com.perenco.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;


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

    private String obtenerNombreRol( final List<RolEntity> roles, final String rolId) {
        String nombreRol = "";

        for ( RolEntity rolEntity: roles) {
          if (rolEntity.getId().equalsIgnoreCase(rolId) ){
              nombreRol = rolEntity.getNombre();
              break;
          }

        }
        return nombreRol;
    }

}
