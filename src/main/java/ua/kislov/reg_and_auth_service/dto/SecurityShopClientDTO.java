package ua.kislov.reg_and_auth_service.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SecurityShopClientDTO {
    private long clientId;
    private String username;
    private String password;
    private String role;
}
