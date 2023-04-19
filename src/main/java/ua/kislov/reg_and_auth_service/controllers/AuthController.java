package ua.kislov.reg_and_auth_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kislov.reg_and_auth_service.dto.SecurityShopClientDTO;
import ua.kislov.reg_and_auth_service.exception.UserNotFoundException;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.services.SecurityService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SecurityService securityService;
    private final ModelMapper mapper;

    @Autowired
    public AuthController(SecurityService securityService, ModelMapper mapper) {
        this.securityService = securityService;
        this.mapper = mapper;
    }

    @GetMapping("/exists-client")
    ResponseEntity<Boolean> existsByUsername(@RequestParam("username") String username) throws UserNotFoundException {
        return new ResponseEntity<>(securityService.existByUsername(username), HttpStatus.OK) ;

    }

    @GetMapping("/security-client")
    ResponseEntity<SecurityShopClientDTO> findByUsername(@RequestParam("username") String username) throws UserNotFoundException {
        SecurityShopClient securityShopClient = securityService.findByUsername(username);
        System.out.println(securityShopClient);
        SecurityShopClientDTO dto = toDTO(securityShopClient);
        System.out.println(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/security-client")
    ResponseEntity<Void> save(@RequestBody SecurityShopClient securityShopClient) {
        securityService.save(securityShopClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private SecurityShopClientDTO toDTO(SecurityShopClient client){
        return mapper.map(client, SecurityShopClientDTO.class);
    }
}
