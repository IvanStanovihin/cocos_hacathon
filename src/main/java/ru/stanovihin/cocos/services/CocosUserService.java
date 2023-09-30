package ru.stanovihin.cocos.services;

import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.repositories.CocosUserRepository;

@Service
public class CocosUserService {

    private final CocosUserRepository cocosUserRepository;

    public CocosUserService(CocosUserRepository cocosUserRepository) {
        this.cocosUserRepository = cocosUserRepository;
    }

    public boolean existsByLogin(String username){
        CocosUser cocosUser = cocosUserRepository.findByLogin(username).get();
        System.out.println("Found existed user: " + cocosUser);
        return cocosUser != null;
    }

    public CocosUser createUser(CocosUser cocosUser){
        return cocosUserRepository.save(cocosUser);
    }
}
