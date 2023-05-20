package ua.kislov.reg_and_auth_service.services.interfaces;

import org.springframework.transaction.annotation.Transactional;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;

public interface SecurityInterface {
    boolean existByUsername(String username);

    SecurityShopClient findByUsername(String username);

    @Transactional
    void save(SecurityShopClient securityShopClient);
}
