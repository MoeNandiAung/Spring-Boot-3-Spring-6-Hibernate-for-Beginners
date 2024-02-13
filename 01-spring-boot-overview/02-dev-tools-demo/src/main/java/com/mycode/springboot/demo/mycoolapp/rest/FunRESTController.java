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

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run a hard 5k";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getNewFortune()
    {
        return "In this year, you will get all the things you want!";
    }
}
