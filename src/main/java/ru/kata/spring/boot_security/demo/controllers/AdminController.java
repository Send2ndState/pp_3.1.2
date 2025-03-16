package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController() {
    }

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String adminPanel(Model model) {
        User admin = userService.getCurrentUser();
        model.addAttribute("userView", admin);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("roles", roleService.getAllRoles());

        model.addAttribute("userNew", new User());

        return "admin-page";
    }

    @PostMapping("/submit")
    public String createUser(@ModelAttribute("userNew") User userNew) {
        userService.saveUser(userNew);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public User getUserForEdit(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public User getUserForDelete(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}

