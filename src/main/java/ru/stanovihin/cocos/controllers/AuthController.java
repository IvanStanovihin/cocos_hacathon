package ru.stanovihin.cocos.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.stanovihin.cocos.models.Role;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.models.rest.LoginRequest;
import ru.stanovihin.cocos.services.AuthenticationService;
import ru.stanovihin.cocos.services.CocosUserService;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final CocosUserService cocosUserService;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;


    public AuthController(CocosUserService cocosUserService, AuthenticationService authenticationService,
                          PasswordEncoder passwordEncoder) {
        this.cocosUserService = cocosUserService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("Received /signin loginRequest: " + loginRequest);
        return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("Received /signup loginRequest: " + loginRequest);
        return ResponseEntity.ok(authenticationService.register(loginRequest));
    }
}
