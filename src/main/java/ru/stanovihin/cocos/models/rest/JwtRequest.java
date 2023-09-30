package ru.stanovihin.cocos.models.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class JwtRequest {
    private String login;
    private String password;
}
