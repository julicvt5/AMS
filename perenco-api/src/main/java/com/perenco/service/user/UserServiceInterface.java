package com.perenco.service.user;

import com.perenco.dto.LoginDTO;
import com.perenco.dto.UserDTO;

import java.util.List;

public interface UserServiceInterface {

    public List<UserDTO> usuarios();

    public UserDTO guardar(final UserDTO userDTO);

    public UserDTO editar(final UserDTO userDTO);

}
