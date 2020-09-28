package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(path = "/ping")
    public String ping() {
        return "ping";
    }

    @GetMapping(path = "/pong")
    public String pong() {
        return "pong";
    }

    @GetMapping(path = "/hello")
    public String hello(){ return "Hello World"}
}


