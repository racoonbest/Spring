package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingsController {
    private final AtomicInteger counter = new AtomicInteger();
    private static final String template = "Hello, %s!";
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
