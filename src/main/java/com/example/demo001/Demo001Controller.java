package com.example.demo001;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo001Controller {
    @RequestMapping("/Hello")
    public String Hello(){ return "~~~" ;}
}
