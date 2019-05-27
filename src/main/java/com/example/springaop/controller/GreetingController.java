package com.example.springaop.controller;

import com.example.springaop.controller.validation.NameConstraint;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name") @NameConstraint @NotNull String name) {
        return "Hello " + name;
    }

}
