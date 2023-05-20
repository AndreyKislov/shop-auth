package ua.kislov.reg_and_auth_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kislov.reg_and_auth_service.exception.UserNotFoundException;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.repositories.SecurityRepository;
import ua.kislov.reg_and_auth_service.services.interfaces.SecurityInterface;

@Service
@Transactional(readOnly = true)
public class SecurityService implements SecurityInterface {

    private final SecurityRepository securityRepository;

    @Autowired
    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Override
    public boolean existByUsername(String username) {
        return securityRepository.existsByUsername(username);
    }

    @Override
    public SecurityShopClient findByUsername(String username) {
        return securityRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User is not found"));
    }

    @Override
    @Transactional
    public void save(SecurityShopClient securityShopClient) {
        securityRepository.save(securityShopClient);
    }
}
