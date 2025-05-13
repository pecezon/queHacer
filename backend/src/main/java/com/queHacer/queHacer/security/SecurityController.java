package com.queHacer.queHacer.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/open")
    public String open(){
        return "OPEN";
    }

    @GetMapping("/closed")
    public String closed(){
        return "CLOSED";
    }

    @PostMapping("/post")
    public String post(){
        return "POST";
    }

    @GetMapping("/special")
    public String special(){

        return "SPECIAL";
    }

    @GetMapping("/basic")
    public String basic(){
        return "BASIC";
    }


}
