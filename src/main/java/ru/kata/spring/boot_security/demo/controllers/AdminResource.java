package ru.kata.spring.boot_security.demo.controllers;

import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/api")
public class AdminResource {

    private final UserService userService;

    @Autowired
    public AdminResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable Long userId) {
        return userService.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteById(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }
}

