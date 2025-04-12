package br.edu.ifsp.user_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class User {

    private int id;
    private String login;
    private String password;

}
