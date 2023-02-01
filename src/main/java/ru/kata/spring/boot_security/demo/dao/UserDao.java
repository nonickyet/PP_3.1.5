package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    User findByEmail(String email);

    void delete(int id);

    void update(User user);

    boolean add(User user);

    List<User> getAllUsers();

    User getById(int id);
}
