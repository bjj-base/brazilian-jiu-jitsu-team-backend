package com.example.videos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/api/hello" )
    public String firstPage(Principal principal) {
        return principal.getName();
    }

}
