package ua.kislov.reg_and_auth_service.services.interfaces;

import org.springframework.data.domain.Page;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;

public interface AdminInterface {

    Page<SecurityShopClient> findByAll(int page, int size, String sort);
    SecurityShopClient findById(long id);

    void deleteUser(long id);
}
