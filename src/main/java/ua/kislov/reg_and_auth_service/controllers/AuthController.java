package ua.kislov.reg_and_auth_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.services.SecurityService;

@RestController("/auth")
public class AuthController {

    private final SecurityService securityService;

    @Autowired
    public AuthController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/exists-client")
    ResponseEntity<String> existsByUsername(String username){
        if(securityService.existByUsername(username))
            return new ResponseEntity<>("Username is already exist", HttpStatus.OK);
        else
            return new ResponseEntity<>("Username is not found", HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/auth/security-client")
//    ResponseEntity<SecurityShopClient> findByUsername(String username){
//
//    }
//
//    @PostMapping("/auth/security-client")
//    ResponseEntity<SecurityShopClient> save(SecurityShopClient securityShopClient){
//
//    }

}
