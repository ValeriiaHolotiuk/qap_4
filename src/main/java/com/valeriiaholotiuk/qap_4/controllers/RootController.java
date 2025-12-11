package com.valeriiaholotiuk.qap_4.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String hello() {
        return "{\"message\":\"Golf Club API is running\"}";
    }
}
