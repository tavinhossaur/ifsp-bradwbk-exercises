package br.edu.ifsp.user_api.model.DTO;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Validated
@AllArgsConstructor @NoArgsConstructor @Getter
public class UserDTO {
    
    @NotBlank(message = "Login should not be empty")
    private String login;

    @NotBlank(message = "Password should not be empty")
    private String password;

}
