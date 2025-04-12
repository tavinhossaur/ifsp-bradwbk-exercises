package br.edu.ifsp.user_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.model.DTO.UserDTO;
import br.edu.ifsp.user_api.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository uRepository;

    public List<User> getUserList() {
        return uRepository.getAllUsers();
    }

    public User getUser(int id) {
        User user = uRepository.getUserById(id);

        if (user == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The id selected doesn't exist on the database.");

        return user;
    }

    public User createUser(UserDTO user) {
        return uRepository.createUser(user);
    }

    public User updateUser(int id, UserDTO newUser) {
        return uRepository.updateUserById(this.getUser(id).getId(), newUser);
    }

    public User deleteUser(int id) {
        return uRepository.deleteUserById(this.getUser(id).getId());
    }

}
