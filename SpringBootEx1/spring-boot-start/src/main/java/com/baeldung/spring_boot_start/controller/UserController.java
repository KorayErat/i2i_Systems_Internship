package com.baeldung.spring_boot_start.controller;

import com.baeldung.spring_boot_start.model.User;
import com.baeldung.spring_boot_start.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Listele
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Ekle
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
