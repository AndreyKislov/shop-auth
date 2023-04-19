package ua.kislov.reg_and_auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityShopClientListDTO {
    private List<SecurityShopClient> list;
    private int pageTotal;
}
