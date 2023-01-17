package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userService.addUser(user);
            return "redirect:/admin";
        }
    }

    @RequestMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "edit";
    }

    @RequestMapping(path = "/edit")
    public String update(User user, BindingResult bindingResult) {
        System.out.println("we are here");
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        } else {
            userService.updateUser(user);
            return "redirect:/admin";
        }
    }
}