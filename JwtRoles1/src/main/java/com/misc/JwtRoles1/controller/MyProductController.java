package com.misc.JwtRoles1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class MyProductController {

    @GetMapping("/helloworldproduct")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String helloworldproduct() {
        return "Hello World Product is a secured endpoint.";
    }

}