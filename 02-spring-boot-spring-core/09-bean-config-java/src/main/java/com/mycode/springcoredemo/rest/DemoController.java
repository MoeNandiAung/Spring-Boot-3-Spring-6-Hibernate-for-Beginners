package com.mycode.springcoredemo.rest;

import com.mycode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependencies
    private Coach myCoach;
    private Coach anotherCoach;


    // Define a setter for dependency injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach)
    {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;

    }
    // Define mapping for daily workout
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    // Check the bean scopes

}
