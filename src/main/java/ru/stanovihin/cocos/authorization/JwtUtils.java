package ru.stanovihin.cocos.authorization;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.stanovihin.cocos.models.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setRoles(Role.build(getRoles(claims)));
        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

    private static String getRoles(Claims claims) {
        final String roles = claims.get("roles", String.class);
        return roles;
    }

//    public static String getLogin(Claims claims){
//        String userLogin = claims.get("login", String.class);
//        System.out.println("User login from jwtToken: " + userLogin);
//        return userLogin;
//    }

}
