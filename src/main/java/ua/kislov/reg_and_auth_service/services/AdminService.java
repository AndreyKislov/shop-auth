package ua.kislov.reg_and_auth_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.kislov.reg_and_auth_service.exception.UserNotFoundException;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;
import ua.kislov.reg_and_auth_service.repositories.AdminRepository;
import ua.kislov.reg_and_auth_service.services.interfaces.AdminInterface;

@Service
public class AdminService implements AdminInterface {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Page<SecurityShopClient> findByAll(int page, int size, String sort) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(sort));
        return adminRepository.findAll(pageable);
    }

    @Override
    public SecurityShopClient findById(long id) {
        return adminRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User is not found"));
    }

    @Override
    public void deleteUser(long id) {
        adminRepository.deleteById(id);
    }
}
