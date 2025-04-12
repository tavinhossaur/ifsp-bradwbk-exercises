package br.edu.ifsp.user_api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsp.user_api.model.User;

@Component
public class UserInitDataSource implements CommandLineRunner {
    
    @Autowired
    UserDataSource uDataSource;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 50; i++) {
            uDataSource.add(i, new User(i, "user " + i, "12345"));
        }
    }

}
