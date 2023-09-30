package ru.stanovihin.cocos.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.services.CocosUserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final CocosUserService cocosUserService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CocosUser> getByToken(String jwtToken){
        System.out.println("Received /GET user, jwtToken: " + jwtToken);
        return ResponseEntity.ok(cocosUserService.findByToken(jwtToken));
    }
}
