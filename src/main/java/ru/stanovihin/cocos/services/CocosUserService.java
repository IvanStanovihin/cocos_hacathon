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
import ru.stanovihin.cocos.models.entities.Activity;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.repositories.CocosUserRepository;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CocosUserService{

    private final JwtProvider jwtProvider;
    private final JwtFilter jwtFilter;
    private final CocosUserRepository cocosUserRepository;

    public CocosUserService(JwtProvider jwtProvider, JwtFilter jwtFilter,
                            CocosUserRepository cocosUserRepository) {
        this.jwtProvider = jwtProvider;
        this.jwtFilter = jwtFilter;
        this.cocosUserRepository = cocosUserRepository;
    }

    public Optional<CocosUser> findByLogin(String login){
        return cocosUserRepository.findByLogin(login);
    }

    public CocosUser findByRequest(HttpServletRequest request){
//        final Claims claims = jwtProvider.getAccessClaims(jwtToken);
//        String userLogin = JwtUtils.getLogin(claims);
        String userLogin = jwtFilter.getLogin(request);
        CocosUser user = cocosUserRepository.findByLogin(userLogin).get();
        System.out.println("User found by token: " + user);
        return user;
    }

    public List<CocosUser> findSortedByCoins(){
        return cocosUserRepository.findSortedByCoins();
    }

    public CocosUser save(CocosUser cocosUser){
        return cocosUserRepository.save(cocosUser);
    }
}
