package ua.kislov.reg_and_auth_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;

@Repository
public interface AdminRepository extends JpaRepository<SecurityShopClient, Long> {
}
