package ua.kislov.reg_and_auth_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kislov.reg_and_auth_service.dto.SecurityShopClientListDTO;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.services.interfaces.AdminInterface;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminInterface adminService;

    @Autowired
    public AdminController(AdminInterface adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public ResponseEntity<SecurityShopClientListDTO> users(@RequestParam(value = "page", required = false) int page,
                                                          @RequestParam(value = "size", required = false) int size,
                                                          @RequestParam(value = "sortBy", required = false) String sortBy) {
        Page<SecurityShopClient> clientPage = adminService.findByAll(page, size, sortBy);
        SecurityShopClientListDTO dto = new SecurityShopClientListDTO(clientPage.toList(), clientPage.getTotalPages());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<SecurityShopClient> user(@PathVariable("id") long id){
        return new ResponseEntity<>(adminService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") long id){
        adminService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
