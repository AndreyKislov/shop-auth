package ua.kislov.reg_and_auth_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<SecurityShopClient, Long> {
    boolean existsByUsername(String username);
    Optional<SecurityShopClient> findByUsername(String username);

}
