package ru.stanovihin.cocos.models.rest;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@Data
@Builder
public class SignupRequest {

    private HttpStatus code;
    private String message;
}
