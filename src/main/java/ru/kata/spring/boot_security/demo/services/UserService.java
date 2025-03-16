package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
    User getCurrentUser();
    User save(User user);
    Optional<User> findById(Long id);
}
