package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.io.Serializable;
import java.util.List;

public interface UserService extends UserDetailsService, Serializable {
    List<User> getAllUsers();

    User getUserByEmail(String email);

    User getUserById(long id);

    void addUser(User user);

    void removeUser(long id);

    void updateUser(User user);
}
