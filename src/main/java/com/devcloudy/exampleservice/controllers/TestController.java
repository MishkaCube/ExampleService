package com.devcloudy.exampleservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "api/test")
    private String hello() {
        return "Hello";
    }

}
