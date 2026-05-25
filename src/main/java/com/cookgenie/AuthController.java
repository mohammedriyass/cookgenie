package com.cookgenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            Model model) {
        if (userService.usernameExists(username)) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        if (userService.emailExists(email)) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }
        userService.registerUser(username, email, password);
        return "redirect:/login";
    }

}
