package ru.stanovihin.cocos.models.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RefreshJwtRequest {

    public String refreshToken;

}
