package ru.kata.spring.boot_security.demo.controllers;

import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable Long userId) {
        return userService.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }
}

