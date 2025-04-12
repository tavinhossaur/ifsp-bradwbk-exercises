package br.edu.ifsp.user_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.model.DTO.UserDTO;
import br.edu.ifsp.user_api.util.UserDataSource;

@Repository
public class UserRepository {

    @Autowired
    UserDataSource uDataSource;

    public List<User> getAllUsers() {
        return uDataSource.getDataSource();
    }

    public User getUserById(int id) {
        Optional<User> user = getAllUsers().stream().filter(u -> u.getId() == id).findFirst();

        if (!user.isPresent()) return null;

        return user.get();
    }

    public int getLastUserId() {
        return getAllUsers().getLast().getId();
    }

    public User createUser(UserDTO user) {
        return uDataSource.create(new User(getAllUsers().getLast().getId() + 1, user.getLogin(), user.getPassword()));
    }

    public User updateUserById(int id, UserDTO newUser) {
        return uDataSource.update(id, new User(id, newUser.getLogin(), newUser.getPassword()));
    }

    public User deleteUserById(int id) {
        return uDataSource.delete(id);
    }

}
