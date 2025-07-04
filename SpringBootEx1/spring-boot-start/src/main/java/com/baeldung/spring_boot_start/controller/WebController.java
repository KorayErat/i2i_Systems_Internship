package com.baeldung.spring_boot_start.controller;

import com.baeldung.spring_boot_start.model.User;
import com.baeldung.spring_boot_start.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final UserRepository userRepository;

    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user-form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users-view";
    }

    @GetMapping("/users-view")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }
    @GetMapping("/error-test")
    public String causeError() {
        throw new RuntimeException("Bu bir test hatasıdır.");
    }
}
