package ua.kislov.reg_and_auth_service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import ua.kislov.reg_and_auth_service.details.ClientDetails;
import ua.kislov.reg_and_auth_service.models.SecurityShopClient;

import java.util.Collections;

@Component
public class JWTUtil {

    @Value("${jwt.secret-string}")
    private String secret;

    public Authentication validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("Kislov")
                .build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return getAuth(decodedJWT);
    }
    private Authentication getAuth(DecodedJWT decodedJWT){
        Claim role = decodedJWT.getClaim("role");
        Claim user = decodedJWT.getClaim("user");
        String password = "somePassword";
        if(role.isNull() && user.isNull()) {
            SecurityShopClient client = new SecurityShopClient(0, "user", "password", "ROLE_USER");
            ClientDetails details = new ClientDetails(client);
            return new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
        }else {
            SecurityShopClient client = new SecurityShopClient(0, user.asString(), password, "ROLE_ADMIN");
            ClientDetails details = new ClientDetails(client);
            return new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
        }
    }
}
