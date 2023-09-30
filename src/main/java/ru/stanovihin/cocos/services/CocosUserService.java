package ru.stanovihin.cocos.services;

import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.authorization.JwtFilter;
import ru.stanovihin.cocos.authorization.JwtProvider;
import ru.stanovihin.cocos.authorization.JwtUtils;
import ru.stanovihin.cocos.models.Role;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.repositories.CocosUserRepository;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CocosUserService{

    private List<CocosUser> users;
    private final JwtProvider jwtProvider;
    private final JwtFilter jwtFilter;
    private final CocosUserRepository cocosUserRepository;

    public CocosUserService(JwtProvider jwtProvider, JwtFilter jwtFilter,
                            CocosUserRepository cocosUserRepository) {
        this.jwtProvider = jwtProvider;
        this.jwtFilter = jwtFilter;
        this.cocosUserRepository = cocosUserRepository;
    }


    @PostConstruct
    void init(){
        this.users = List.of(
                new CocosUser(1L, "admin", "admin", "Антон", "Иванов", Collections.singleton(Role.USER)),
                new CocosUser(2L, "user", "user", "Сергей", "Петров", Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<CocosUser> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

    public CocosUser findByToken(String jwtToken){
        final Claims claims = jwtProvider.getAccessClaims(jwtToken);
        String userLogin = JwtUtils.getLogin(claims);
        CocosUser user = cocosUserRepository.findByLogin(userLogin).get();
        System.out.println("User found by token: " + user);
        return user;
    }
}
