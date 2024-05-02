package com.example.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;


@RestController
public class HelloController
{
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello , Welcome to Daily Code Buffer!!";
    }

}
