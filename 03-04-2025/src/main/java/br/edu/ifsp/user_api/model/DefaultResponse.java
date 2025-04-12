package br.edu.ifsp.user_api.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DefaultResponse {

    private String message;
    private String status;
    private int code;

    public DefaultResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.getReasonPhrase();
        this.code = status.value();
    }

}
