package com.example.videos.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/api/hello" )
    public String firstPage(Principal principal) {
        return principal.getName();
    }

}
