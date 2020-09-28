package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/pong")
    public String pong() {
        return "ping";
    }

}


