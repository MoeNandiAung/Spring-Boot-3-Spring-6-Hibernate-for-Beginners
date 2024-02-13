package com.mycode.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRESTController {

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello Justine!";
    }
}
