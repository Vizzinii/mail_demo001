package com.example.mailsystem.controller;

import com.example.mailsystem.entity.UserEntity;
import com.example.mailsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestParam String username,
                                   @RequestParam String email,
                                   @RequestParam String password) {
        return userService.registerUser(username, email, password);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        UserEntity user = userService.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found."));

        if (!userService.validatePassword(password, user.getPassword())) {
            throw new RuntimeException("Invalid password.");
        }

        return "Login successful";
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
    }
}