package ru.stanovihin.cocos.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.services.CocosUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final CocosUserService cocosUserService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CocosUser> getByToken(HttpServletRequest request){
        System.out.println("Received GET /user");
        return ResponseEntity.ok(cocosUserService.findByRequest(request));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CocosUser> save(@RequestBody CocosUser cocosUser){
        System.out.println("Received POST /save cocosUser: " + cocosUser);
        return ResponseEntity.ok(cocosUserService.save(cocosUser));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rating")
    public ResponseEntity<List<CocosUser>> getRating(){
        System.out.println("Received GET /rating");
        return ResponseEntity.ok(cocosUserService.findSortedByCoins());
    }
}
