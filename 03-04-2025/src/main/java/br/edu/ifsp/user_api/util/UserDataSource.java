package br.edu.ifsp.user_api.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.ifsp.user_api.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Component
@AllArgsConstructor @Getter
public class UserDataSource {

    private ArrayList<User> dataSource;

    public void add(int id, User user) { 
        dataSource.add(id, user);
    }

    public User create(User user) { 
        dataSource.addLast(user); 
        return dataSource.getLast(); 
    }

    public User update(int id, User user) { 
        dataSource.set(id, user);
        return dataSource.get(id); 
    }

    public User delete(int id) { 
        return dataSource.remove(id); 
    }
}
