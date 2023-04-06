package ua.kislov.reg_and_auth_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kislov.reg_and_auth_service.repositories.SecurityRepository;

@Service
public class SecurityService {

    private final SecurityRepository securityRepository;

    @Autowired
    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    public boolean existByUsername(String username){
        return securityRepository.existsByUsername(username);
    }


}
