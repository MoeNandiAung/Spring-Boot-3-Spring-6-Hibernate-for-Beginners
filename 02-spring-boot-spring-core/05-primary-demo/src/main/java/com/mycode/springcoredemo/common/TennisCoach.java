package com.mycode.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public String getDailyWorkout(){
        return "Practive your backhand valley";
    }
}
