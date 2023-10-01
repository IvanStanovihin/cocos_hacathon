package ru.stanovihin.cocos.models;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("ADMIN"),
    USER("USER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }

    public static Role build(String value){
        switch (value){
            case "ADMIN":
                return Role.ADMIN;
            case "USER":
                return Role.USER;
        }
        return null;
    }
}