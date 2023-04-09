package ua.kislov.reg_and_auth_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kislov.reg_and_auth_service.exception.UserNotFoundException;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.services.SecurityService;

import javax.net.ssl.SSLEngineResult;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SecurityService securityService;

    @Autowired
    public AuthController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/exists-client")
    ResponseEntity<Boolean> existsByUsername(@RequestParam("username") String username) throws UserNotFoundException {
        System.out.println(username + " from existByUsername");
        return new ResponseEntity<>(securityService.existByUsername(username), HttpStatus.OK) ;

    }

    @GetMapping("/security-client")
    ResponseEntity<SecurityShopClient> findByUsername(@RequestParam("username") String username) throws UserNotFoundException {
        SecurityShopClient securityShopClient = securityService.findByUsername(username);
        return new ResponseEntity<>(securityShopClient, HttpStatus.OK);
    }

    @PostMapping("/security-client")
    ResponseEntity<Void> save(@RequestBody SecurityShopClient securityShopClient) {
        securityService.save(securityShopClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
