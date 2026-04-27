package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PlanService {

    private boolean enabled;

    private PlanProperties properties;

    public PlanService(
            @Value("${planer.enabled:false}") boolean enabled,
            PlanProperties properties
    ){
        this.enabled = enabled;
        this.properties = properties;
    }

    public void printConfig() {
        System.out.println("enabled=" + enabled);
        System.out.println("defaultDuration=" + properties.getDefault_duration());
        System.out.println("batchSize=" + properties.getBatch_size());
    }

}
