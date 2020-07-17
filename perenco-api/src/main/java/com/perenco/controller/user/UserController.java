package com.perenco.controller.user;

import com.perenco.dto.LoginDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.login.LoginServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<UserDTO> users() {
        return userServiceInterface.usuarios();
    }

    @PostMapping(  consumes = "application/json", produces = "application/json")
    public UserDTO save(@RequestBody final UserDTO userDTO) {
        return userServiceInterface.save(userDTO);
    }
    
}
