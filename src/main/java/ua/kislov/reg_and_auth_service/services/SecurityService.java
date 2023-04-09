package ua.kislov.reg_and_auth_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kislov.reg_and_auth_service.exception.UserNotFoundException;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.repositories.SecurityRepository;

@Service
@Transactional(readOnly = true)
public class SecurityService {

    private final SecurityRepository securityRepository;

    @Autowired
    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    public boolean existByUsername(String username) {
        return securityRepository.existsByUsername(username);
    }

    public SecurityShopClient findByUsername(String username) {
        return securityRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User is not found"));
    }

    @Transactional
    public void save(SecurityShopClient securityShopClient) {
        securityRepository.save(securityShopClient);
    }
}
