package com.example.it_one;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class WalletController {
    @GetMapping
    public String test(){
        return "AAAAAA";
    }
}
