package com.mycode.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach{
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }

}
