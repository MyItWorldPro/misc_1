package com.misc.JwtRoles1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class MyAuthController {

    @GetMapping("/helloworld")
    public String helloworld() {
        return "Hello World is not a secured endpoint. Anyone can access it !!!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome is not a secured endpoint. Anyone can access it !!!";
    }

    @PostMapping("/signup")
    public String signup() {
        return "Sign Up";
    }

    @PostMapping("/login")
    public String login() {
        return "Log In";
    }

}
