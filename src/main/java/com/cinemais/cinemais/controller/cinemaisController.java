package com.cinemais.cinemais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cinemaisController {
    
    @GetMapping("/index")
    public String exibirIndex(){
        return "index";
    }
}
