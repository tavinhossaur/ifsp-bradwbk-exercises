package br.edu.ifsp.user_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifsp.user_api.model.DefaultResponse;
import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.model.DTO.UserDTO;
import br.edu.ifsp.user_api.routes.Routes;
import br.edu.ifsp.user_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(Routes.API)
public class UserController {

    @Autowired
    UserService uService;

    @GetMapping(Routes.USERS)
    public List<User> getAllUsers() {
        return uService.getUserList();
    }

    @GetMapping(Routes.USERS + Routes.BY_ID)
    public User getUser(@PathVariable int id) {
        return uService.getUser(id);
    }

    @PostMapping(Routes.USERS)
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO user) {
        User createdUser = uService.createUser(user);

        if (createdUser == null) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error trying to create the user.");

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping(Routes.USERS + Routes.BY_ID)
    public User updateUser(@PathVariable int id, @RequestBody @Valid UserDTO user) {
        User updatedUser = uService.updateUser(id, user);

        if (updatedUser == null) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error trying to update the user.");

        return updatedUser;
    }

    @DeleteMapping(Routes.USERS + Routes.BY_ID)
    public DefaultResponse deleteUser(@PathVariable int id) {
        User deletedUser = uService.deleteUser(id);

        if (deletedUser == null) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error trying to delete the user.");

        return new DefaultResponse("User deleted successfully.", HttpStatus.OK);
    }
    
}
