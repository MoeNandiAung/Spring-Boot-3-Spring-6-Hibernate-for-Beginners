package com.mycode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach()
    {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    public String getDailyWorkout()
    {
        return "Spend 30 minutes in batting practices";
    }
}
