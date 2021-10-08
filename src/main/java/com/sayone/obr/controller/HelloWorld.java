package com.sayone.obr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("Hello")
    public String Hello() {
        return "Hai Friends";
    }
}
