package ru.stanovihin.cocos.models.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class JwtResponse {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
