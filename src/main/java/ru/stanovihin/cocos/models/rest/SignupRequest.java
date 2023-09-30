package ru.stanovihin.cocos.models.rest;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
public class SignupRequest {

    private HttpStatus code;
    private String message;
}
