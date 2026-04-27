package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PlanProperties {

    @Value("${planer.defaultDuration:50}")
    private int default_duration;

    @Value("${planer.batchSize:50}")
    private int batch_size;

    public int getBatch_size() {
        return batch_size;
    }

    public int getDefault_duration() {
        return default_duration;
    }
}
