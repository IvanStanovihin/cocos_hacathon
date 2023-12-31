package ru.stanovihin.cocos.models.rest;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Data
@Accessors(chain = true)
public class LoginRequest {

    private String login;
    private String password;
}
