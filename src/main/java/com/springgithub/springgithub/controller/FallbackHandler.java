package com.springgithub.springgithub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FallbackHandler {

    @RequestMapping("/github")
    public String github() {
        return "index.html";
    }

    @RequestMapping("/stackoverflow")
    public String stackoverflow() {
        return "index.html";
    }

    @RequestMapping("/twitter")
    public String twitter() {
        return "index.html";
    }

}