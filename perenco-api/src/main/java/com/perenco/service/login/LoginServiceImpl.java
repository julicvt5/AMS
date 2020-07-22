package com.perenco.service.login;

import com.perenco.dto.LoginDTO;
import com.perenco.repository.user.UserEntity;
import com.perenco.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class LoginServiceImpl implements LoginServiceInterface{

    @Autowired
    private UserRepository userRepository;


    @Override
    public LoginDTO getLogin(LoginDTO loginDTO) {

        log.info(" Entro a getLogin : {} ", loginDTO);

        UserEntity userEntity = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword())
                .orElseThrow(RuntimeException::new);
        loginDTO.setId(userEntity.getIdUser());

        return loginDTO;
    }
}
