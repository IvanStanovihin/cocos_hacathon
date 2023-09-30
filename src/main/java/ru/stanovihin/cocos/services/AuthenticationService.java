package ru.stanovihin.cocos.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.models.Role;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.models.rest.LoginRequest;
import ru.stanovihin.cocos.repositories.CocosUserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CocosUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(LoginRequest request) {
        var user = new CocosUser()
                .setLogin(request.getLogin())
                        .setPassword(passwordEncoder.encode(request.getPassword()))
                                .setRole(Role.User);
        var savedUser = repository.save(user);
        System.out.println("Saved user: " + savedUser);
        var jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }

    public String authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        var user = repository.findByLogin(request.getLogin())
                .orElseThrow();
        System.out.println("Found user: " + user);
        var jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }
}