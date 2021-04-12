package com.app.jpa.security.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String welcome(){
        return "Welcome !!!";
    }

    @GetMapping("/user")
    public String userEndpoint(){
        return "User Endpoint !!!";
    }

    @GetMapping("/role")
    public String roleEndpoint(){
        return "Role Endpoint !!!";
    }

}
