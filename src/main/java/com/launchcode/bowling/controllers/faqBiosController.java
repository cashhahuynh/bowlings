package com.launchcode.bowling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class faqBiosController {

    @GetMapping("faqBios")
    public String createFaqBios(){
        return "faqBios";
    }

}
