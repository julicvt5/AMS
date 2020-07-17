package com.perenco.controller.login;

import com.perenco.dto.LoginDTO;
import com.perenco.service.login.LoginServiceImpl;
import com.perenco.service.login.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginServiceInterface loginService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public LoginDTO getLogin(@RequestBody final LoginDTO login) {
        return loginService.getLogin(login);
    }

}
