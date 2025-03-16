//package ru.kata.spring.boot_security.demo.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.kata.spring.boot_security.demo.entities.User;
//import ru.kata.spring.boot_security.demo.services.RoleService;
//import ru.kata.spring.boot_security.demo.services.UserService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController1 {
//
//    private UserService userService;
//    private RoleService roleService;
//
//    public AdminController1() {
//    }
//
//    @Autowired
//    public AdminController1(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping("/new_user")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "new";
//    }
//
//    @GetMapping("/edit")
//    public String editUser(@RequestParam("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "edit";
//    }
//
//    @PostMapping("/submit")
//    public String save(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping
//    public String adminPage(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "all-users";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }
//
//}
