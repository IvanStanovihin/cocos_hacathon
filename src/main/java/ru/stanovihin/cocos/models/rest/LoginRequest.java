package ru.stanovihin.cocos.models.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginRequest {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
