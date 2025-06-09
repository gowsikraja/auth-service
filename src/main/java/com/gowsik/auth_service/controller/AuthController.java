package com.gowsik.auth_service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthController {

    @GetMapping("init")
    public String init() {
        return "Hello Gowsik";
    }

}
