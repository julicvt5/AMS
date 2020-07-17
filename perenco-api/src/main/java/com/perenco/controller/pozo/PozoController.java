package com.perenco.controller.pozo;

import com.perenco.dto.PozoDTO;
import com.perenco.dto.UserDTO;
import com.perenco.service.pozo.PozoServiceInterface;
import com.perenco.service.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pozo")
public class PozoController {

    @Autowired
    private PozoServiceInterface pozoService;

    @GetMapping(  consumes = "application/json", produces = "application/json")
    public List<PozoDTO> pozos() {
        return pozoService.pozos();
    }

}
