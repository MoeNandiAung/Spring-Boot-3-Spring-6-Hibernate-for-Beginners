package com.mycode.springcoredemo.config;

import com.mycode.springcoredemo.common.Coach;
import com.mycode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
