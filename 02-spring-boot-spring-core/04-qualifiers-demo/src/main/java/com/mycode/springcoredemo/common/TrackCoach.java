package com.mycode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }

}
